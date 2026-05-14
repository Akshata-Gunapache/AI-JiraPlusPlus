# 🚀 AI Jira++ — AI-Driven Distributed Workflow Management Platform

AI Jira++ is a distributed workflow management platform inspired by Jira, built using **Spring Boot**, **Angular**, **JWT Authentication**, **FastAPI**, **WebSockets**, and **Google Cloud Platform**.

The platform enables secure multi-user task management through a real-time Kanban workflow system with AI-assisted task prioritization and cloud-native deployment architecture.

---

# ✨ Features

## 🔐 Secure Authentication
- JWT-based authentication
- Spring Security integration
- Stateless session management
- Multi-user task isolation

## 📋 Kanban Workflow Management
- Drag-and-drop Kanban board
- TODO → IN PROGRESS → DONE workflow
- Dynamic task filtering
- Task deletion support
- Due dates & timestamps

## 🤖 AI-Powered Task Prioritization
- AI-assisted task priority prediction
- Python FastAPI microservice
- Context-aware priority analysis
- Intelligent workflow categorization

## ⚡ Real-Time Collaboration
- WebSocket-ready STOMP architecture
- Distributed synchronization design
- Real-time task collaboration system

## ☁️ Cloud-Native Deployment
- Google Cloud Platform (App Engine)
- Cloud SQL-ready architecture
- GitHub Actions CI/CD pipeline

---

# 🛠️ Tech Stack

## Backend
- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- Maven
- MySQL

## Frontend
- Angular
- Angular CDK Drag & Drop
- TypeScript
- CSS

## AI Service
- Python
- FastAPI

## Cloud & DevOps
- Google Cloud Platform
- Cloud SQL
- GitHub Actions

---

# 🏗️ System Architecture

```text
Angular Frontend
        │
        ▼
Spring Boot REST APIs
        │
 ┌──────┴──────┐
 ▼             ▼
MySQL      WebSocket Layer
                 │
                 ▼
       Real-Time Synchronization

FastAPI AI Service
(Task Priority Prediction)
