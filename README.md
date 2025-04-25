# TomEE Bug Demo

This project demonstrates an issue in TomEE where JAX-RS endpoints are incorrectly captured by a wildcard servlet (`/*`) after changes made in [TOMEE-4406](https://issues.apache.org/jira/browse/TOMEE-4406) and [PR #1524](https://github.com/apache/tomee/pull/1524).

## Project Structure

- `JaxRsApplication.java`: REST application with base path `/api`
- `HelloResource.java`: REST endpoint at `/hello`
- `WildcardServlet.java`: Servlet with `/*` mapping that incorrectly captures REST requests

## How to Run

1. Build the project:
   ```
   ./gradlew war
   ```

2. Deploy the WAR file (`build/libs/tomee-bug-demo.war`) to TomEE

3. Access the application at: `http://localhost:8080/tomee-bug-demo/`

## Testing the Bug

- REST endpoint URL: `http://localhost:8080/tomee-bug-demo/api/hello`
  - Expected: JSON response from the REST endpoint
  - Actual: HTML response from the wildcard servlet
