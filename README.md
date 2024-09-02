<h1 align="center">Calculator Service API</h1>

<p align="center">
  <img alt="AWS Lambda Badge" src="https://img.shields.io/badge/AWS_Lambda-orange.svg" />
  <img alt="Java Language Badge" src="https://img.shields.io/badge/Java-17.x-green.svg" />
  <img alt="Clojure Language Badge" src="https://img.shields.io/badge/Clojure-1.11.x-green.svg" />
  <img alt="MySQL Database Badge" src="https://img.shields.io/badge/MySQL-8.3-green.svg" />
</p>

<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0; 
  <a href="#sparkles-features">Features</a> &#xa0; | &#xa0;
  <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-testing">Testing</a> &#xa0; | &#xa0;
  <a href="#mag_right-migrations">Migrations</a> &#xa0; | &#xa0;
  <a href="https://github.com/douglasffilho" target="_blank">Author</a>
</p>

<br>

## :dart: About ##

A calculator service that taxes customer operations over their budget amount.

## :sparkles: Features ##

- [x] Operations
  - [x] model
    - [x] only type
    - [x] add cost
  - [x] logic
    - [x] addition
    - [x] subtraction
    - [x] multiplication
    - [x] division
    - [x] square-root
    - [x] random-string
    - [x] unknown-operation error
  - [x] controller
    - [x] default operations
    - [x] random-string integration with external service in the Operations Controller
      - [x] HTTP client layer to communicate with the integration
      - [x] HTTP call to random-string generation before default logic (only executes default logic in a circuit-break case as a fallback)
  - [x] database migrations
    - [x] create
    - [x] run

- [ ] Database
  - [x] Create local MySQL database using docker
  - [ ] Create remote MySQL database using AWS RDS MySQL free tier
  - [x] Create migrations
  - [x] run local database migrations
  - [ ] run remote database migrations

- [ ] Customers
  - [ ] Basic Authentication Flow (generates JWT token with expiration time)
  - [ ] database migrations
    - [ ] create
    - [ ] run

- [ ] Records
  - [ ] Register log per operation per customer
    - [ ] validate and update (if possible) balance at transaction level
  - [ ] Paginated (searchable, filterable and sortable) list of Records per customer only for the authenticated customer
  - [ ] Record deletion for authenticated customer
  - [ ] database migrations
    - [ ] create
    - [ ] run

- [ ] Lambda HTTP handlers
  - [ ] Customer
    - [ ] Authentication
  - [ ] Operations
  - [ ] Records
    - [ ] List
    - [ ] Delete

## :rocket: Technologies ##

The following tools were used in this project:

- [AWS Lambda](https://aws.amazon.com/pt/pm/lambda/)
- [Java](https://www.oracle.com/br/java/technologies/downloads/#java17)
- [Clojure](https://clojure.org/)
- [Leiningen](https://leiningen.org/)
- [MySQL 8.3](https://hub.docker.com/layers/library/mysql/8.0-oracle/images/sha256-0cb3ab06963a548f8eebb5aca9e06a0ea86db8178030f2e12edda36143a41259?context=explore)

## :white_check_mark: Requirements ##

Before starting :checkered_flag:, you need to have [Git](https://git-scm.com), [Java](https://www.oracle.com/br/java/technologies/downloads/#java17) and [Docker](https://www.docker.com/) globally installed.
I recommend you to install [SDKMan! tool](https://sdkman.io/) to help managing different Java versions locally

## :checkered_flag: Starting ##

```bash
# Clone this project
$ git clone https://github.com/douglasffilho/calculator-service

# Access
$ cd calculator-service

# Install dependencies
$ lein deps

# Make local MySQL available
$ docker compose up -d

# After tests, remember removing local MySQL
$ docker compose down -v
```

## :checkered_flag: Migrations ##

```bash
# Run migrations locally
$ lein run migrations

# Run migrations for remote(production) database specifying database through env vars
$ MYSQL_DB_HOST=localhost MYSQL_DB_PORT=3306 MYSQL_DB_NAME=calculator MYSQL_DB_USER=root MYSQL_DB_PWD=admin lein run migrations
```

## :mag_right: Testing ##

```bash
# Test entire project
$ lein test
```

Made with :heart: by <a href="https://github.com/douglasffilho" target="_blank">douglasffilho</a>

&#xa0;

<a href="#top">Back to top</a>
