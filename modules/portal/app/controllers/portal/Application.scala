package controllers.portal

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.portal.index("Your new application is ready."))
  }

}