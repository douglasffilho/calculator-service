<h1 align="center">Calculator Service API</h1>

<p align="center">
  <img alt="AWS Lambda Badge" src="https://img.shields.io/badge/AWS_Lambda-orange.svg" />
  <img alt="Java Language Badge" src="https://img.shields.io/badge/Java-17.x-green.svg" />
  <img alt="Clojure Language Badge" src="https://img.shields.io/badge/Clojure-1.11.x-green.svg" />
  <img alt="MySQL Database Badge" src="https://img.shields.io/badge/MySQL-5.7.36-green.svg" />
</p>

<p align="center">
  <a href="#dart-about">About</a> &#xa0; | &#xa0; 
  <a href="#sparkles-features">Features</a> &#xa0; | &#xa0;
  <a href="#rocket-technologies">Technologies</a> &#xa0; | &#xa0;
  <a href="#white_check_mark-requirements">Requirements</a> &#xa0; | &#xa0;
  <a href="#checkered_flag-starting">Starting</a> &#xa0; | &#xa0;
  <a href="#mag_right-testing">Testing</a> &#xa0; | &#xa0;
  <a href="https://github.com/douglasffilho" target="_blank">Author</a>
</p>

<br>

## :dart: About ##

A calculator service that taxes customer operations over their budget amount.

## :sparkles: Features ##

- [ ] Operations
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
  - [ ] database migrations

- [ ] Database
  - [ ] Create local MySQL database using docker
  - [ ] Create remote MySQL database using AWS RDS MySQL free tier
  - [ ] Create migrations

- [ ] Customers
  - [ ] Basic Authentication Flow (generates JWT token with expiration time)
  - [ ] database migrations

- [ ] Records
  - [ ] Register log per operation per customer
    - [ ] validate and update (if possible) balance at transaction level
  - [ ] Paginated (searchable, filterable and sortable) list of Records per customer only for the authenticated customer
  - [ ] Record deletion for authenticated customer
  - [ ] database migrations

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
- [MySQL 5.7.36](https://hub.docker.com/layers/library/mysql/5.7.36/images/sha256-398f124948bb3d5789c0ac7c004d02e6d9a3ae95aa9804d7a3b33a344ff3c9cd?context=explore)

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
```

## :mag_right: Testing ##

```bash
# Test entire project
$ lein test
```

Made with :heart: by <a href="https://github.com/douglasffilho" target="_blank">douglasffilho</a>

&#xa0;

<a href="#top">Back to top</a>
