# Adrian Vrabie – Java Software Engineer

**Phone:** +41 762575204 || **Email:** mr.vrabie@gmail.com

**StackOverflow:** [moldovean](https://stackoverflow.com/users/959876/moldovean) || **Github:** [avrabie](https://github.com/avrabie) ||
**Blog:** [blog.s4v3.net](https://blog.s4v3.net)

------

## Professional Summary

- **Senior Software Engineer** with 10+ years of experience focusing on the design and development of scalable, high-performance distributed systems using Java and the Spring ecosystem.

- **Reactive Programming:** Hands-on experience with Spring WebFlux and Project Reactor, building non-blocking and resilient microservices and APIs where appropriate.

- **Security & Identity:** Experience working with OAuth2/OIDC, mTLS, and identity management standards such as SCIM 2.0 in enterprise environments.

- **Cloud-Native & Distributed Systems:** Contributed to the gradual modernization of legacy systems into containerized microservices (Docker, Kubernetes), and worked with cloud platforms such as Azure.

- **Team Collaboration & Delivery:** Experience working within engineering teams (5+), contributing across the full SDLC—from requirements and design through to production deployment and ongoing maintenance.

- **Analytical & Mathematical Background:** MSc in Mathematics with exposure to areas such as Hidden Markov Models and algorithmic optimization.

- **AI-Assisted Development:** Work in Progress: Trying to incorporate AI-assisted coding tools (Junie, Codex, Claude Code) into the development workflow, using structured frameworks (e.g., Embabel) to guide (restrict) outputs in order to maintain code quality and reduce adverse effects.

---

## Technical Skills


## Programming Languages
- primary: Java (JDK SE/EE 8+), 
- other: Python, C, PL/SQL, Julia, R, SQL, Kotlin
- FE: React (with Junie)

## Frameworks, Libraries & Tools
- Spring Boot, Spring Webflux, Spring Security, Spring Data, Spring MVC, Spring Cloud
- Beginner: Spring AI, Embabel
- Swagger/OpenAPI, 
- JUnit, Mockito, Testcontainers 
- JAX-RS, JMS, JPA (Hibernate)
- Cloud: Azure, PCF, Hetzner
- Docker, Podman, Kubernetes, Docker Compose, Rancher
- Observability: ELK Stack, OTEL
- OAuth2, JWT, SAML, mTLS

### Databases
- Oracle, PostgreSQL, H2, Cassandra, MongoDB

---

###  Opensource Projects
- Horus Gateway: A high-performance *API Gateway* built on *Spring Cloud Gateway*, serving as the central entry point for a microservices ecosystem. It handles intelligent request routing, traffic monitoring, and cross-cutting security concerns.
  - Links:  [GitHub Repository](https://github.com/gluonstream/horus-gateway) || [Blog Technical Deep-dive](https://blog.s4v3.net) || [Live Streaming Demo](https://s4v3.net)

- Key Features
  - **Intelligent Routing:** Dynamically routes traffic to diverse backends (MinIO Storage, Blog API, and Frontends) using path, host, and query-based predicates.
  - **Robust Security:** Implements **OAuth2 & OpenID Connect (OIDC)** with **Keycloak** for unified authentication and authorization.
  - **Reactive Analytics:** Leverages **Redis (Reactive)** for real-time visitor tracking and distributed session management via custom gateway filters.
  - **Cloud-Native Architecture:** Designed for scalability with **Kubernetes**, featuring health probes, environment-specific **Kustomize** overlays, and automated **Docker** builds.

- Tech Stack
  - **Languages & Frameworks:** Java 25, Spring Boot 4.x, Spring Cloud Gateway (WebFlux), Spring Security.
  - **Data & Caching:** Redis (Reactive Data & Session).
  - **Security:** OAuth2, OIDC, JWT, Keycloak.
  - **Infrastructure:** Docker, Kubernetes, Kustomize, Gradle (Kotlin DSL).

---

## Professional Experience

### UBS AG, Zurich, Switzerland
**Role:** Senior Java Software Engineer  
**Duration:** Feb 2023 – Present

- **Facade Service** – Developed a unified interface for multiple backend services of ELA Archive; facilitated document ingestion and retrieval during Credit Suisse (CS) migration.  
  **Tech Stack:** Java 21+, Spring Boot 3, Spring WebFlux (Project Reactor), REST APIs, Apigee, Kafka, k8s ready.

- **Papdocs Generator** – Built a microservice for generating temporary document placeholders for customers to enable specific banking services.  
  **Tech Stack:** Java, Spring Boot, Maven, GitLab CI, Oracle (Stored Procedures).

- **RDS Microservice** – Implemented operational commands for retrieving RDS (Reference Data System) data via Apigee.  
  **Tech Stack:** Java, Spring Boot, OpenAPI, Apigee.

- **Pollers Migration** – Migrated legacy Perl scripts to high-performance Java microservices, improving maintainability and observability.  
  **Tech Stack:** Java, Spring Boot, Spring Scheduler, REST APIs, Docker, Kubernetes, CI/CD.

- **Archive Manager (AM)** – Implemented the "Fisca 2.0" regulatory feature within a large-scale Java EE monolith.  
  **Tech Stack:** Java EE, IBM WebSphere, Oracle.

- **Soman** – Maintained the frontend for 1IP (One Investment Platform).  
  **Tech Stack:** Java 8, JSP.

- **NSCDA** – Developed logic for updating and enriching entitlements for Corporate Actions (CA) based on BBS rights.  
  **Tech Stack:** Java, Spring Boot, WebFlux, Project Reactor Sinks.

### Tech Mahindra, Zurich, Switzerland
**Role:** Senior Java Software Engineer  
**Client:** Sunrise  
**Duration:** Oct 2022 – Feb 2023

- **SCIM 2.0 Identity Management** – Implemented SCIM 2.0 protocol for automated user provisioning and identity management.  
  **Tech Stack:** Kotlin, Spring Boot, Project Reactor, Azure, Kubernetes.
- **Infrastructure as Code** – Designed and implemented Azure infrastructure using Terraform and automated CI/CD pipelines.  
  **Tech Stack:** Terraform, Azure DevOps, Networking (VNet/Private Endpoints).

### Allegis Group, Switzerland
**Role:** Senior Java Software Engineer  
**Client:** Zurich Insurance  
**Duration:** May 2022 – Oct 2022

- **Vehicle Search Product** – Developed and deployed a high-performance vehicle search service based on Swiss license plates.  
  **Tech Stack:** Java 11, Project Reactor, Docker, Cosmos DB, Azure.
- **DataLoader Microservice** – Built a secure data ingestion service with restricted internal API access.  
  **Tech Stack:** Spring Boot, Azure, REST.
- **Cloud Architecture Optimization** – Re-architected a serverless-based solution into a more robust and manageable Spring Boot containerized application.
- **PvTools PoC** – Developed a Proof of Concept integrating Azure Graph API with Excel-based actuarial models to expose them as web services.  
  **Tech Stack:** Java, Azure Graph API, Microsoft Excel Integration.

---

### EPAM GmbH, Switzerland
**Role:** Software Engineer (Contractor)  
**Client:** UBS AG  
**Duration:** Aug 2020 – Jun 2022

- **OAuth2 Resource Provider** – Engineered a custom OAuth2 resource provider from scratch, deployed on Pivotal Cloud Foundry (PCF).  
  **Tech Stack:** Java, Spring Security, OAuth2, PCF.
- **Security Integration** – Integrated the product with core enterprise systems including Identity Providers (IdP), Vaults, and Authorization services.  
- **Secure Communication** – Implemented mTLS, managed key stores, and enforced secure service-to-service communication standards.  
  **Tech Stack:** Spring Security (Custom Auth Providers), mTLS, JWT.

---

### Ciorici Consulting LLC / Comcast, USA
**Role:** Software Engineer (Contractor)  
**Duration:** Oct 2018 – Mar 2020

- Developed SD-WAN product using Java 8 and plugin architecture.
- Optimized algorithms (reduced complexity from polynomial → linear).
- Built auxiliary Spring Boot services for automation.
- Maintained >90% test coverage.
- Introduced Git workflow improvements.
- Worked with Kubernetes, Rancher, Kibana.

---

### Endava Inc
**Role:** Software Engineer  
**Client:** UK Financial Services  
**Duration:** 2018

- Designed technical architecture and documentation.
- Implemented SSO (SAML, OAuth2).
- Built SOAP services and backend integrations.
- Conducted security scans and enforced standards.

---

### Endava Inc
**Role:** Software Engineer  
**Client:** Global Card Scheme  
**Duration:** 2016 – 2018

- Developed payment systems and REST APIs.
- Implemented internationalization and ISO integrations.
- Migrated sensitive data handling (FPAN → DPAN).
- Enhanced payment authorization logic.

---

### ASCOM Holding SA
**Role:** Software Developer / Consultant  
**Duration:** 2014 – 2016

- Designed underwriting systems for insurance.
- Built REST APIs and automated pipelines.
- Led code reviews and security compliance.
- Integrated legacy systems and refactored components.

---

### MoldATSA SE
**Role:** Software Consultant, Head of Strategy  
**Duration:** 2010 – 2014

- Led integration of air traffic management systems.
- Managed team of 5 engineers.
- Built forecasting models using R and Python.
- Developed contingency and cost optimization plans.
- Worked with European Commission and EUROCONTROL.

---

## Education

- **MSc in Mathematics** – State University of Moldova  
  Thesis: Hidden Markov Models & Parameter Estimation

- **Master’s Degree** – Albert Ludwigs University Freiburg  
  (Computer Science & Economics)

- **Exchange Program** – Clemson University (USA) (2004 – 2005)

---

## Publications

- *“Estimating the transition probability matrix in Hidden Markov Models”*  
  MITRE-2016 Conference, ISBN: 978-9975-71-794-6