package edu.austral.ingsis.math;

public class Try<S, F extends Exception> {

  S success;
  F fail;

  public Try(S success) {
    this.success = success;
  }

  public Try(F fail) {
    this.fail = fail;
  }

  public S getSuccess() {
    return success;
  }

  public void setSuccess(S success) {
    this.success = success;
  }

  public F getFail() {
    return fail;
  }

  public void setFail(F fail) {
    this.fail = fail;
  }

  public boolean isSuccess() {
    return success != null;
  }

  public boolean isFail() {
    return fail != null;
  }
}
