# Java Web Crawler

This Java application is designed to navigate the web, index pages, and extract specific content. Utilizing the [Jsoup](https://jsoup.org/) HTML parsing library and managed with Maven, the crawler operates to a depth of 2 links, retrieving target titles, links, and text, and subsequently saving them to a file.

## Features

- **Web Crawling**: Initiates from a seed URL and explores linked pages up to a depth of 2.
- **Content Extraction**: Parses and extracts titles, hyperlinks, and textual content from web pages.
- **Data Storage**: Saves the extracted information into a structured file for further analysis or processing.
- **Robots.txt Compliance**: Respects web scraping policies by adhering to the `robots.txt` directives of each site.

## How It Works

1. **Initialization**: Begins with a seed URL added to the frontier queue.
2. **Fetching**: Retrieves the HTML content of the URL.
3. **Parsing**: Uses Jsoup to parse the HTML and extract links and desired content.
4. **Duplication Check**: Verifies if the URL or its content has been previously crawled to avoid redundancy.
5. **Compliance Verification**: Checks the site's `robots.txt` file to ensure adherence to crawling policies.
6. **Iteration**: Adds new, uncrawled, and compliant URLs to the frontier queue, repeating the process up to the specified depth.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure JDK 8 or higher is installed.
- **Maven**: For project dependency management.
- **Jsoup Library**: Included as a Maven dependency.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/KELVI23/Java-Web-Crawler.git
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd Java-Web-Crawler
   ```

3. **Build the Project with Maven**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   - Execute the `Main` class to start the web crawling process.
   - Monitor the console output for progress and results.

## Configuration

- **Seed URL**: Modify the `seedUrl` variable in the `Main` class to change the starting point of the crawl.
- **Crawling Depth**: Adjust the `maxDepth` variable to set the desired depth of link traversal.
- **Output File**: Specify the destination file for extracted data in the `outputFilePath` variable.

## Notes

- **Ethical Crawling**: Always ensure compliance with each website's `robots.txt` directives and terms of service.
- **Performance Considerations**: Be mindful of the load imposed on servers; implement appropriate delays between requests if necessary.
- **Data Accuracy**: The quality of extracted data depends on the structure of the target web pages and may require adjustments to parsing logic.

## License

This project is open-source. Feel free to modify and use it according to your needs.

---

*For issues, contributions, or further information, please refer to the [GitHub repository](https://github.com/KELVI23/Java-Web-Crawler).* 
