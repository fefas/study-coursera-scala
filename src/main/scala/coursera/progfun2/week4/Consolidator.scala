package coursera.progfun2.week4

class Consolidator(observed: List[BankAccount]) extends Subscriber {
  observed.foreach(_.subscribe(this))

  private var total: Int = _

  compute()

  private def compute() = total = observed.map(_.currentBalence).sum

  def handler(pub: Publisher) = compute()

  def totalBalance = total
}
