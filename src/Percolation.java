/**
 * Created by Alexey Kutepov on 26.01.15.
 */
public class Percolation {

  private WeightedQuickUnionUF uf;
  private boolean[][] gird;
  private boolean[][] girdFill;
  private final int N;
  private boolean percolated;

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
    girdFill = new boolean[N][N];
    percolated = false;
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
      filling(I, J);
    }
    if (I > 0 && gird[I - 1][J]) {
      if (girdFill[I - 1][J]) {
        filling(I, J);
      }
      uf.union(position(I, J), position(I - 1, J));
    }
    if (I < N-1 && gird[I + 1][J]) {
      if (girdFill[I + 1][J]) {
        filling(I, J);
      }
      uf.union(position(I, J), position(I + 1, J));
    }
    if (J > 0 && gird[I][J - 1]) {
      if (girdFill[I][J - 1]) {
        filling(I, J);
      }
      uf.union(position(I, J), position(I, J - 1));
    }
    if (J < N-1 && gird[I][J + 1]) {
      if (girdFill[I][J + 1]) {
        filling(I, J);
      }
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
    return girdFill[I][J];
  }

  /**
   * is system percolated?
   * @return true - system is percolated, else - false
   */
  public boolean percolates() {
//    for (int i = 0; i < N; i++) {
//      if (girdFill[N - 1][i]) {
//        return true;
//      }
//    }
    return percolated;
  }

  private int position(int i, int j) {
    return N*i + j;
  }

  private void filling(int i, int j) {
    girdFill[i][j] = true;
    if (i == N - 1) {
      percolated = true;
    }
    if (i > 0 && gird[i - 1][j] && !girdFill[i - 1][j]) {
      filling(i - 1, j);
    }
    if (i < N-1 && gird[i + 1][j] && !girdFill[i + 1][j]) {
      filling(i + 1, j);
    }
    if (j > 0 && gird[i][j - 1] && !girdFill[i][j - 1]) {
      filling(i, j - 1);
    }
    if (j < N-1 && gird[i][j + 1] && !girdFill[i][j + 1]) {
      filling(i, j + 1);
    }
  }



  public static void main(String[] args) {
    // write your code here
  }

}
