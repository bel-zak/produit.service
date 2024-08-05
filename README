 README.md

# Microservice de Gestion de Produits

## Description

Ce projet est un microservice de gestion de l'inventaire des produits développé avec Spring Boot. Il expose une API REST permettant d'ajouter, de supprimer, de mettre à jour et de récupérer des informations sur les produits.

## Prérequis

- **Java 17** ou version supérieure
- **Maven 3.8.1** ou version supérieure

## Configuration du Projet

1. **Cloner le dépôt :**

   git clone https://github.com/bel-zak/produit.service.git
   cd produit-service

Construire le projet :

mvn clean install
Lancer l'application :
mvn spring-boot:run

L'application démarrera sur : http://localhost:8080.

Endpoints de l'API REST:

Ajouter un nouveau produit
URL: POST /api/products
____________ json utilisé pour le test ___________________

{
  "name": "Nom du produit",
  "stockQuantity": 100,
  "price": 50.0
}
________________________________________
Récupérer la liste de tous les produits
URL: GET /api/products

Récupérer un produit spécifique par son ID
URL: GET /api/products/{id}

Mettre à jour un produit existant
URL: PUT /api/products/{id}

Supprimer un produit (authentification requise)
URL: DELETE /api/products/{id}


Authentification
Pour accéder aux endpoints protégés (notamment pour la suppression des produits), utilisez les informations de connexion suivantes :

Username: admin
Password: password