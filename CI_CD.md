# CI/CD setup

The GitHub Actions workflow runs on pushes to `main`. It builds and tests the
project, then builds the Docker image locally in the runner. It does not publish
the image or require Docker Hub credentials.

## Local build and run

The test suite uses H2, so `mvnw.cmd -B clean verify` does not require MySQL.
To run the application locally, set `MYSQL_PASSWORD` and ensure MySQL is
running with the `student_db` database created. `MYSQL_URL` and
`MYSQL_USERNAME` can also override the defaults in `application.properties`.

The Docker image listens on port `8082`. When running it, provide
`MYSQL_URL`, `MYSQL_USERNAME`, and `MYSQL_PASSWORD` so the container can reach
your database.
