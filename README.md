# TastyTales Backend

TastyTales Backend is a Kotlin-based backend service for the TastyTales application, which provides a RESTful API to
manage and serve recipes. The project leverages Ktor for its server framework and uses Docker for deployment, making it
easy to set up and scale.

<img src="./src/main/resources/tastytales-logo.jpg" alt="TastyTales Logo" width="300"/>

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running Locally](#running-locally)
    - [Running with Docker](#running-with-docker)
    - [Running on Render](#running-on-render)
- [Database](#database)
    - [Schema Overview](#schema-overview)
- [API Endpoints](#api-endpoints)

## Features

- RESTful API for managing recipes.
- SQLite database for persistent data storage.
- Basic authentication for secure API access.
- Dockerized for easy deployment and scalability.
- Environment-specific configurations (development and production).

## Getting Started

### Prerequisites

Before you begin, ensure you have the following tools installed:

- **Java 17** or later
- **Gradle 7** or later
- **Docker** (for containerized deployment)
- **Git** (for version control)

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Barros9/TastyTalesBackend.git
   cd tastytales-backend
    ```
2. **Set Up Local Configuration**:
- Create a `local.properties` file in the project root with the following content:
  ```properties
  username=yourLocalUsername
  password=yourLocalPassword
  ```

### Running Locally

To run the application locally with the default configuration:

```bash
./gradlew run
```

This command starts the Ktor server at http://localhost:8080.

#### Example CLI Call
Once the server is running, you can test the API using curl with the provided credentials and language preferences:

```bash
curl -u yourLocalUsername:yourLocalPassword -H "Accept: application/json" -H "Accept-Language: en" "http://localhost:8080/recipes/1"
```
- `-u yourLocalUsername:yourLocalPassword`: This option is used to pass the Basic Authentication credentials.
- `-H "Accept: application/json"`: This header tells the server that the client expects the response in JSON format.
- `-H "Accept-Language: en"`: This header specifies the preferred language for the response, in this case, English (en).
- `http://localhost:8080/recipes/1`: This is an example endpoint; in this case the recipe with id 1.

### Running with Docker
To run the application using Docker:

1. **Build the Docker Image**:
   ```bash
   docker build -t tastytales-backend .
    ```

2. **Build the Docker Image**:
   ```bash
   docker run -p 8080:8080 tastytales-backend
    ```

The server will be available at http://localhost:8080.

### Running on Render

If you are deploying this application to Render, you'll need to set the environment variables manually through the Render dashboard:

1. **Navigate to your service in Render**:
Go to the Render dashboard and select the service where you want to deploy the application.

2. **Go to the "Environment" tab**: In the service settings, find the "Environment" tab.

3. **Add the following environment variables**:
   1. `KTOR_USERNAME`: Your chosen username for basic authentication.
   2. `KTOR_PASSWORD`: Your chosen password for basic authentication.

4. **Deploy the service**: Once the environment variables are set, deploy the service through the Render dashboard. Render will automatically pick up these environment variables and use them when running your application.

Ensure these variables are correctly configured to match those used in your local or Docker setup.

## Database

The project uses an SQLite database for storing recipe data. The database is already included within the project and contains 50 pre-populated recipe instances.

- **Local Development**: The database file is located at `src/main/resources/TastyTalesDatabase.db`.
- **Docker Deployment**: The database file is located at `/app/TastyTalesDatabase.db` within the container.

### Schema Overview

The `TastyTalesDatabase` schema is designed to handle recipes, their ingredients, instructions, reviews with their translations. Below is a brief overview of the tables:

#### `Recipes`

This table stores the main details about each recipe:

- **name**: Name of the recipe.
- **description**: Description of the recipe.
- **imageUrl**: Optional URL to the recipe's image.
- **preparationTime**: Time required for preparation (in minutes).
- **cookingTime**: Time required for cooking (in minutes).
- **restingTime**: Optional resting time (in minutes).
- **servings**: Number of servings.
- **difficulty**: Difficulty level (e.g., "Easy", "Medium", "Hard").
- **tags**: Optional tags for categorization.
- **mealType**: Type of meal (e.g., "Dinner", "Breakfast").
- **isVegetarian**: Boolean flag for vegetarian recipes.
- **isGlutenFree**: Boolean flag for gluten-free recipes.
- **isDairyFree**: Boolean flag for dairy-free recipes.
- **isNutFree**: Boolean flag for nut-free recipes.
- **spiceLevel**: Level of spiciness.
- **caloriesPerServing**: Optional calories per serving.
- **author**: Optional author of the recipe.
- **averageRating**: Optional average rating from reviews.
- **createdAt**: Timestamp of when the recipe was created.
- **updatedAt**: Optional timestamp of when the recipe was last updated.

#### `RecipesTranslations`

This table manages translations for recipe names, descriptions, and tags:

- **recipeId**: Foreign key referencing the `Recipes` table.
- **language**: Language code (e.g., "en" for English).
- **name**: Translated name of the recipe.
- **description**: Translated description of the recipe.
- **tags**: Optional translated tags.

#### `Ingredients`

This table stores the ingredients required for each recipe:

- **recipeId**: Foreign key referencing the `Recipes` table.
- **name**: Name of the ingredient.
- **quantity**: Optional quantity of the ingredient.
- **unit**: Optional unit of measurement.

#### `IngredientsTranslations`

This table manages translations for ingredient names, quantities, and units:

- **ingredientId**: Foreign key referencing the `Ingredients` table.
- **language**: Language code (e.g., "en" for English).
- **name**: Translated name of the ingredient.
- **quantity**: Optional translated quantity.
- **unit**: Optional translated unit.

#### `Instructions`

This table stores the step-by-step instructions for preparing each recipe:

- **recipeId**: Foreign key referencing the `Recipes` table.
- **stepNumber**: Step number in the sequence.
- **description**: Description of the step.
- **optionalTip**: Optional tip for the step.

#### `InstructionsTranslations`

This table manages translations for the instructions:

- **instructionId**: Foreign key referencing the `Instructions` table.
- **language**: Language code (e.g., "en" for English).
- **description**: Translated description of the step.
- **optionalTip**: Optional translated tip for the step.

#### `Reviews`

This table stores reviews given by users for recipes:

- **recipeId**: Foreign key referencing the `Recipes` table.
- **user**: Name of the user who provided the review.
- **rating**: Rating given to the recipe.
- **comment**: Optional comment provided by the user.
- **date**: Date when the review was submitted.

#### `ReviewsTranslations`

This table manages translations for the review comments:

- **reviewId**: Foreign key referencing the `Reviews` table.
- **language**: Language code (e.g., "en" for English).
- **comment**: Optional translated comment.

## API Endpoints

The application provides two main API endpoints for managing and retrieving recipes. All endpoints are protected with Basic Authentication, which requires valid credentials to access.

### 1. **GET /recipes**

**Description:**
This endpoint retrieves a paginated list of recipes. The response can be tailored to the user's preferred language using the `Accept-Language` header.

**Request:**
- **Method:** `GET`
- **URL:** `/recipes`
- **Headers:**
  - `Authorization`: Basic Authentication header (required)
  - `Accept-Language`: The preferred language for the recipe details (optional, default is `en`).
- **Query Parameters:**
  - `page`: The page number for pagination (optional, default is `1`).
  - `pageSize`: The number of items per page (optional, default is `MAX_PAGE_SIZE`).

**Response:**
- **200 OK:** Returns a list of recipes in the requested language.
- **204 No Content:** If no recipes are found for the given page.
- **500 Internal Server Error:** If an unexpected error occurs on the server.

**Example Request:**
  ```bash
  curl -u yourUsername:yourPassword -H "Accept-Language: it" "http://localhost:8080/recipes?page=1&pageSize=10"
  ```

**Example Response:**
  ```json
    [
      {
        "id": 1,
        "name": "Mystical Dragon Curry",
        "description": "A fantastical curry with a blend of magical spices and mystical ingredients.",
        ...
      },
      {
        "id": 2,
        "name": "Elven Bread of Immortality",
        "description": "A mystical bread said to grant longevity to those who consume it, baked with rare ingredients found only in enchanted forests.",
        ...
      },
      ...
    ] 
  ```

### 2. **GET /recipes/{id}**

**Description:**
This endpoint retrieves the details of a single recipe by its ID. The response can be tailored to the user's preferred language using the `Accept-Language` header.

**Request:**
- **Method:** `GET`
- **URL:** `/recipes/{id}`
- **Headers:**
  - `Authorization`: Basic Authentication header (required)
  - `Accept-Language`: The preferred language for the recipe details (optional, default is `en`).
- **Path Parameters:**
  - `id`: The ID of the recipe to retrieve.

**Response:**
- **200 OK:** Returns the recipe details in the requested language.
- **400 Bad Request:** If the recipe ID is invalid or missing.
- **404 Not Found:** If the recipe with the given ID does not exist.
- **500 Internal Server Error:** If an unexpected error occurs on the server.

**Example Request:**
  ```bash
  curl -u yourUsername:yourPassword -H "Accept-Language: it" "http://localhost:8080/recipes/1"
  ```

**Example Response:**
  ```json
    {
      "id": 1,
      "name": "Mystical Dragon Curry",
      "description": "A fantastical curry with a blend of magical spices and mystical ingredients.",
      ...
    }
  ```