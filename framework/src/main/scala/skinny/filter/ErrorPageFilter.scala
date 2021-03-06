package skinny.filter

/**
 * Shows error page when unexpected exceptions are thrown from controllers.
 */
trait ErrorPageFilter extends SkinnyRenderingFilter {

  addRenderingErrorFilter {
    case e: Throwable =>
      logger.error(e.getMessage, e)
      try {
        status = 500
        render("/error/500")
      } catch {
        case e: Exception => throw e
      }
  }

}
