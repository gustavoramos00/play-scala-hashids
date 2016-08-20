package domain

case class Aluguel(id: ID,
                   carroId: ID,
                   diarias: QtdeDiarias,
                   valor: ValorAluguel)

case class QtdeDiarias(value: Int) extends AnyVal {
  override def toString = value.toString
}

case class ValorAluguel(value: Double) extends AnyVal {
  override def toString = value.toString
}
