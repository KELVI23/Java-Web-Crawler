# Web-Crawler

Web Crawler project that navigates the web and indexes pages. The application uses Jsoup(Java html parsing library) and maven package manager.
For testing the app crawls amazon jobs website at the link depth of 2 and returns Leadership principles, links and title then saves them to a file. 

1. In the first step, we first pick a URL from the frontier.
2. Fetch the HTML code of that URL.
3. Get the links to the other URLs by parsing the HTML code.
4. Check whether the URL is already crawled before or not. We also check whether we have seen the same content before or not. If both the condition doesn't match, we add them to the index.
5. For each extracted URL, verify that whether they agree to be checked(robots.txt, crawling frequency)
