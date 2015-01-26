/**
 * Created by Alexey Kutepov on 26.01.15.
 */
public class Percolation {

  private WeightedQuickUnionUF uf;
  private boolean[][] gird;
  private final int N;
  private int[] top;
  private int countTop;
  private int[] bottom;
  private int countBottom;

  /**
   * create N-by-N grid, with all sites blocked
   * @param N
   */
  public Percolation(int N) {
    if (N <= 0) {
      throw new IllegalArgumentException();
    }
    uf = new WeightedQuickUnionUF(N*N);
    this.N = N;
    gird = new boolean[N][N];

    top = new int[N];
    bottom = new int[N];
    countTop = 0;
    countBottom = 0;
  }

  /**
   * open site (row i, column j) if it is not open already
   * @param i - row
   * @param j - column
   */
  public void open(int i, int j) {
    if (i < 1 || i > N || j < 1 || j > N) {
      throw new IndexOutOfBoundsException();
    }
    int I = i - 1;
    int J = j - 1;
    gird[I][J] = true;
    if (I == 0) {
      top[countTop] = position(I, J);
      countTop++;
    } else if (I == N - 1) {
      bottom[countBottom] = position(I, J);
      countBottom++;
    }
    if (I > 0 && gird[I - 1][J]) {
      uf.union(position(I, J), position(I - 1, J));
    }
    if (I < N-1 && gird[I + 1][J]) {
      uf.union(position(I, J), position(I + 1, J));
    }
    if (J > 0 && gird[I][J - 1]) {
      uf.union(position(I, J), position(I, J - 1));
    }
    if (J < N-1 && gird[I][J + 1]) {
      uf.union(position(I, J), position(I, J + 1));
    }
  }

  /**
   * is site (row i, column j) open?
   * @param i - row
   * @param j - column
   * @return true - site is open, else - false
   */
  public boolean isOpen(int i, int j)  {
    if (i < 1 || i > N || j < 1 || j > N) {
      throw new IndexOutOfBoundsException();
    }
    return gird[i-1][j-1];
  }

  /**
   * is site (row i, column j) full?
   * @param i - row
   * @param j - column
   * @return true - site is full, else - false
   */
  public boolean isFull(int i, int j) {
    if (i < 1 || i > N || j < 1 || j > N) {
      throw new IndexOutOfBoundsException();
    }
    int I = i - 1;
    int J = j - 1;
    if (!gird[I][J]) {
      return false;
    } else {
      for (int k = 0; k < countTop; k++) {
        if (uf.connected(position(I, J), top[k])) {
          return true;
        }
      }
      return false;
    }
  }

  /**
   * is system percolated?
   * @return true - system is percolated, else - false
   */
  public boolean percolates() {
    for (int i = 0; i < countTop; i++) {
      for (int j = 0; j < countBottom; j++) {
        if (uf.connected(countTop, countBottom)) {
          return true;
        }
      }
    }
    return false;
  }

  private int position(int i, int j) {
    return N*i + j;
  }

  public static void main(String[] args) {
    // write your code here
  }

}
