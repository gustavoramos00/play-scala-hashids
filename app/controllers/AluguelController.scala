package controllers

import javax.inject.{Inject, Singleton}

import domain.Aluguel
import play.api.mvc.{Action, Controller}

@Singleton
class AluguelController @Inject() extends Controller {

  def list = Action{
    val alugueis = Seq(
      Aluguel(1,1,3, "Golf", 300.0),
      Aluguel(2,2,5, "Pálio", 400.0),
      Aluguel(3,1,1, "Celta", 80.0)
    )

    Ok(views.html.alugueis(alugueis))
  }

}
