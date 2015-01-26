/**
 * Created by Alexey Kutepov on 26.01.15.
 */
public class PercolationStats {

  private double[] thresholds;
  private int T;

  /**
   * perform T independent experiments on an N-by-N grid
   * @param N
   * @param T
   */
  public PercolationStats(int N, int T) {
    if (N <= 0 || T <= 0) {
      throw new IllegalArgumentException();
    } else {
      thresholds = new double[T];
      this.T = T;
      for (int k = 0; k < T; k++) {
        Percolation percolation = new Percolation(N);
        for (int i = 0; i < N * N; i++) {
          percolation.open(StdRandom.uniform(1, N + 1), StdRandom.uniform(1, N + 1));
          if (percolation.percolates()) {
            thresholds[k] = i / (double) N*N;
            break;
          }
        }
      }
    }
  }

  /**
   * sample mean of percolation threshold
   * @return
   */
  public double mean() {
    return StdStats.mean(thresholds);
  }

  /**
   * sample standard deviation of percolation threshold
   * @return
   */
  public double stddev() {
    if (T == 1) return Double.NaN;
    return StdStats.stddev(thresholds);
  }

  /**
   * low  endpoint of 95% confidence interval
   * @return
   */
  public double confidenceLo() {
    return mean() - 1.96*stddev()/Math.sqrt(T);
  }

  /**
   * high endpoint of 95% confidence interval
   * @return
   */
  public double confidenceHi() {
    return mean() + 1.96*stddev()/Math.sqrt(T);
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int t = Integer.parseInt(args[1]);
    PercolationStats stats = new PercolationStats(n, t);
    StdOut.printf("mean = %f\n", stats.mean());
    StdOut.printf("stddev = %f\n", stats.stddev());
    StdOut.printf("95%% confidence interval = %f, %f\n", stats.confidenceLo(), stats.confidenceHi());
  }

}
