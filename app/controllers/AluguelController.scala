package controllers

import javax.inject.{Inject, Singleton}

import domain._
import play.api.mvc.{Action, Controller}

import scala.collection.mutable.ListBuffer

@Singleton
class AluguelController @Inject() extends Controller {

  val alugueis = ListBuffer(
    Aluguel(ID(1), ID(1), QtdeDiarias(3), ValorAluguel(300.0)),
    Aluguel(ID(2), ID(2), QtdeDiarias(5), ValorAluguel(400.0)),
    Aluguel(ID(3), ID(2), QtdeDiarias(1), ValorAluguel(80.0)),
    Aluguel(ID(4), ID(3), QtdeDiarias(1), ValorAluguel(120.0))
  )

  val carros = ListBuffer(
    Carro(ID(1), "Gol"),
    Carro(ID(2), "Pálio"),
    Carro(ID(3), "Celta")
  )

  def list = Action{
    Ok(views.html.alugueis(alugueis))
  }

  def aluguel(id: ID) = Action {
    val result = for {
      aluguel <- alugueis.find(_.id == id)
      carro <- carros.find(_.id == aluguel.carroId)
    } yield (aluguel, carro)

    result match {
      case Some((aluguel, carro)) => Ok(views.html.aluguel(aluguel, carro))
      case _ => NotFound
    }
  }


}
