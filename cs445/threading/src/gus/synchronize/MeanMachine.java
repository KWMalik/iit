package gus.synchronize;

public class MeanMachine extends Thread {
  private String name;
  private Account account;
  private long amountToWithdraw;

  public MeanMachine(String name, Account account, long amountToWithdraw) {
    this.name = name;
    this.account = account;
    this.amountToWithdraw = amountToWithdraw;
    start();
  }

  public void run() {
    // try {
      while(account.withdraw(amountToWithdraw)) {
        printReceipt("Deducted: " + amountToWithdraw + " Remaining");
        // Thread.sleep(10);
      }
    // } catch (InterruptedException e) {}
    printReceipt("Final");
  }

  private void printReceipt(String note) {
    System.out.println("machine " + name + " - " + note + ": " + String.valueOf(account.getBalance()));
  }
}
