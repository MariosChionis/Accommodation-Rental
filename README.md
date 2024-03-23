# Accommodation Rental App

Welcome to the Accommodation Rental App! This application allows users to search for accommodations using a multi-threaded architecture, enhancing performance and responsiveness. The application is divided into three main components: the master, the manager, and the workers.

## Features

- **Accommodation Search:** Users can search for accommodations based on various criteria such as location, price range, and amenities.
- **Multi-threaded Search:** Utilizes threads for parallel processing of user searches, improving efficiency and responsiveness.
- **Master-Manager-Worker Architecture:** Organized into three components for efficient task management and distribution.

## Installation

To run the Accommodation Rental App, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/accommodation-rental-app.git
   ```

2. Navigate to the project directory:

   ```bash
   cd accommodation-rental-app
   ```

3. Install dependencies:

   ```bash
   npm install
   ```

4. Build the application:

   ```bash
   npm run build
   ```

5. Start the application:

   ```bash
   npm start
   ```

## Usage

Once the application is running, users can interact with it through a user-friendly interface:

1. **Search for Accommodations:** Enter criteria such as location, price range, and amenities to find suitable accommodations.
2. **View Results:** Browse through the list of accommodations returned by the search.
3. **Select Accommodation:** Choose a specific accommodation for more details and booking options.
4. **Book Accommodation:** Reserve the selected accommodation if satisfied with the details and pricing.

## Architecture Overview

The Accommodation Rental App employs a master-manager-worker architecture to handle user searches efficiently:

- **Master:** Responsible for receiving user requests and distributing them to available managers.
- **Manager:** Receives search requests from the master and delegates them to worker threads for parallel processing.
- **Worker:** Executes search tasks assigned by the manager, fetching accommodation data from the database and returning results to the manager.

## Contributing

Contributions to the Accommodation Rental App are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/improvement`).
3. Make your changes.
4. Commit your changes (`git commit -am 'Add new feature'`).
5. Push to the branch (`git push origin feature/improvement`).
6. Create a new Pull Request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for de