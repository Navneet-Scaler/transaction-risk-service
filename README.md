# Project : Transaction Risk Evaluation Service  
### Secure Spring Boot Application with Production-Grade DevSecOps CI/CD Pipeline

---

## 📌 Project Overview

The **Transaction Risk Evaluation Service** is a Java Spring Boot–based REST API designed to evaluate financial transactions and assign a **risk score** and **risk category** based on predefined business rules.

The primary focus of this project is to demonstrate a **real-world, production-grade CI/CD pipeline** that integrates **code quality checks, security scanning, container validation, and Kubernetes deployment**, following **DevSecOps and shift-left security principles**.

---

## 🎯 Project Objectives

- Build a real-world backend application using Java & Spring Boot
- Implement a complete **CI pipeline using GitHub Actions**
- Integrate **security early (Shift-Left Security)**
- Perform static, dependency, and container vulnerability scans
- Package the application as a secure Docker image
- Push only **trusted images** to DockerHub
- Deploy the application using a separate **CD pipeline** to Kubernetes

---

## 🧩 Application Architecture

- **Language:** Java 17  
- **Framework:** Spring Boot  
- **Build Tool:** Maven  
- **Architecture Style:** RESTful, stateless service  
- **Containerization:** Docker  
- **Deployment Platform:** Kubernetes  

---

## 📡 API Design

### ➤ Evaluate Transaction Risk

**Endpoint**
```

POST /api/v1/transactions/evaluate

````

**Request Payload**
```json
{
  "transactionId": "TXN1001",
  "amount": 15000,
  "accountAgeDays": 20,
  "country": "IN"
}
````

**Response**

```json
{
  "transactionId": "TXN1001",
  "riskScore": 82,
  "riskLevel": "HIGH"
}
```

---

## ⚙️ Running the Application Locally

### 1️⃣ Prerequisites

Ensure the following are installed:

* Java 17
* Maven
* Docker

---

### 2️⃣ Clone the Repository

```bash
git clone https://github.com/<your-username>/transaction-risk-service.git
cd transaction-risk-service
```

---

### 3️⃣ Run Using Maven

```bash
mvn clean spring-boot:run
```

Application will be available at:

```
http://localhost:8080
```

---

### 4️⃣ Run Using Docker

#### Build Docker Image

```bash
docker build -t transaction-risk-service .
```

#### Run Docker Container

```bash
docker run -p 8080:8080 transaction-risk-service
```

---

## 🐳 Docker Configuration

* Multi-stage Docker build
* Application runs as a **non-root user**
* Optimized for minimal image size
* Designed for Kubernetes compatibility

---

## 🔁 CI/CD Pipeline Architecture

This project implements **two separate pipelines**:

---

## 🔁 Continuous Integration (CI)

📍 **Workflow File:** `.github/workflows/ci.yml`
📍 **Triggers:**

* Push to `main` branch
* Manual trigger (`workflow_dispatch`)

### CI Pipeline Stages

| Stage                 | Purpose                             |
| --------------------- | ----------------------------------- |
| Checkout              | Retrieve source code                |
| Setup Java            | Install runtime                     |
| Unit Tests            | Validate application logic          |
| CodeQL (SAST)         | Detect OWASP Top 10 vulnerabilities |
| Dependency Scan (SCA) | Identify vulnerable libraries       |
| Docker Build          | Create container image              |
| Trivy Image Scan      | Detect OS & library vulnerabilities |
| Runtime Smoke Test    | Validate container startup          |
| Docker Push           | Publish trusted image to DockerHub  |

✔ Fail-fast pipeline
✔ Security gates enforced
✔ Only trusted images are published

---

## 🚀 Continuous Deployment (CD)

📍 **Workflow File:** `.github/workflows/cd.yml`
📍 **Trigger:** Successful CI completion

### CD Responsibilities

* Validate Kubernetes manifests
* Deploy application to Kubernetes cluster
* Verify pod and service health
* Demonstrate real-world deployability

---

## 🔐 Security & DevSecOps Controls

This project follows **Shift-Left Security** principles:

| Security Layer     | Tool                              |
| ------------------ | --------------------------------- |
| SAST               | GitHub CodeQL                     |
| SCA                | Dependency vulnerability scanning |
| Container Security | Trivy                             |
| Secrets Management | GitHub Secrets                    |
| Runtime Validation | Container smoke tests             |

🔒 No secrets are hardcoded in the repository.

---

## 🔑 GitHub Secrets Configuration (Mandatory)

Configure the following secrets in GitHub:

**Repository → Settings → Secrets and variables → Actions**

| Secret Name          | Purpose                |
| -------------------- | ---------------------- |
| `DOCKERHUB_USERNAME` | DockerHub username     |
| `DOCKERHUB_TOKEN`    | DockerHub access token |

⚠️ Marks will be deducted if secrets are committed in code.

---

## ☸️ Kubernetes Deployment

* Kubernetes manifests included
* Uses Docker image built by CI pipeline
* Stateless and scalable service
* Ready for extension with Helm or environment promotion

---

## 📊 Results & Observations

* CI pipeline ensures code quality and security before release
* Vulnerable dependencies and images are detected early
* Only verified and scanned images reach DockerHub
* CD pipeline deploys immutable and trusted artifacts

---

## ⚠️ Limitations & Future Improvements

* Authentication and authorization not implemented
* Rule-based risk engine (can be extended with ML)
* Future enhancements:

  * DAST integration
  * Helm-based deployments
  * Monitoring and observability (Prometheus/Grafana)
  * Blue-green or canary deployments

---

## 🧠 DevOps & DevSecOps Principles Demonstrated

* Automation-first mindset
* Shift-left security
* Separation of CI and CD
* Immutable artifacts
* Secure containerization
* Reproducible deployments

---

## 👨‍💻 Author

**Name:** <Your Name>
**Program:** Scaler DevOps
**Project Type:** Individual CI/CD & DevSecOps Implementation

---

## ✅ Submission Checklist

✔ CI pipeline passing

✔ CD pipeline passing

✔ Docker image published

✔ Security scans enabled

✔ Secrets secured

✔ README complete
