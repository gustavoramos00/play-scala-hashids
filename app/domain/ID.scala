package domain

import org.hashids._
import play.api.mvc.PathBindable

case class ID(value: Long) extends AnyVal {
  override def toString: String = MyHashIds.reference.encode(value)
}

object ID {
  def apply(str: String): ID = {
    val maybeId = MyHashIds.reference.decode(str).headOption
    if (maybeId.isDefined)
      ID(maybeId.get)
    else
      throw new IllegalArgumentException(s"Hash $str inválido")
  }

  implicit def idPathBindable(implicit stringBinder: PathBindable[String]) = new PathBindable[ID] {
    override def bind(key: String, value: String): Either[String, ID] = {
      stringBinder.bind(key, value) match {
        case Right(hash) =>
          try {
            Right(ID(hash))
          } catch {
            case iae: IllegalArgumentException => Left(iae.getMessage)
          }
        case Left(o) => Left(o)
      }
    }

    override def unbind(key: String, value: ID): String = {
      stringBinder.unbind(key, value.toString)
    }
  }
}

object MyHashIds {
  val reference = Hashids.reference(salt = "kalsjda*&a@1+2asd", minHashLength = 4)
}