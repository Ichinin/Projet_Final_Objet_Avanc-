package aspects;

import banque.CompteBancaire;

public aspect TrackingAspect {

  declare parents: CompteBancaire implements AccessTracked;

  private long AccessTracked.lastAccessedTime;
  
  public void AccessTracked.updateLastAccessedTime() {
  lastAccessedTime = System.nanoTime();
  }

  public long AccessTracked.getLastAccessedTime() {
  return lastAccessedTime;
  }

  before(AccessTracked accessTracked): execution(* AccessTracked+.*(..))
  && !execution(* AccessTracked.*(..))
  && this(accessTracked) {
  accessTracked.updateLastAccessedTime();
  }
  
  private static interface AccessTracked {
  }
}