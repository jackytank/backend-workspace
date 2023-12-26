# Cáchê

# **Overview**

- [x]  Enroll in the Redis Certified Developer Program
- [ ]  Complete the following courses at Redis University:
    - [ ]  RU101: Introduction to Redis Data Structures
    - [ ]  RU202: Redis Streams
    - [ ]  RU203: Querying, Indexing, and Full-Text Search (or any other elective course)
- [ ]  Review the study guide and take the practice test
- [ ]  Schedule and take the Redis Certified Developer Exam
- [ ]  Receive your digital badge and certificate

# Detail

### Query

- Small exercise (Convert SQL to Redis Query)
    1. **SELECT * FROM bicycles WHERE price >= 1000**
        
        ```jsx
        ft.search itemIdx '@price:[1000 +inf]'
        ```
        
    2. **SELECT id, price FROM bicycles**
        
        ```jsx
        ft.search itemIdx '*' return 2 __key $.price
        ```
        
    3. **SELECT id, price-price*0.1 AS discounted FROM bicycles**
        
        ```jsx
        FT.AGGREGATE itemIdx '*' LOAD 2 __key $.price APPLY '@price-@price*0.10' AS discounted
        ```
        
    4. **SELECT condition, AVG(price) AS avg_price FROM bicycles GROUP BY condition**
        
        ```jsx
        FT.AGGREGATE itemIdx '*' GROUPBY 1 @condition REDUCE AVG 1 @price AS avg_price
        ```
        
    
- Exact match
    - Numeric field
        - Perform exact price 270
        
        ```jsx
        FT.SEARCH itemIdx '@price:[270 270]'
        FT.SEARCH itemIdx '*' FILTER price 270 270
        ```
        
    - Tag field
        - query for new bicycle
        
        ```jsx
        FT.SEARCH itemIdx '@condition:{new}'
        ```
        
    - Full-text field
        - finding all bicycles that have a description containing the exact text 'rough terrain’
        
        ```jsx
        FT.SEARCH itemIdx '@description:"rough terrain"'
        ```
        
- Range
    - Range queries
        - Finds bicycles within a price range greater than or equal to 500 USD and smaller than or equal to 1000 USD (**`500 <= price <= 1000`**):
        
        ```jsx
        FT.SEARCH itemIdx '@price:[500 1000]'
        FT.SEARCH itemIdx '*' FILTER price 500 1000
        ```
        
        - bicycles with a price greater than 1000 USD (**`price > 1000`**)
        
        ```jsx
        // use [(1000 +inf] instead [1000 +inf] becuz '(' exclude 1000 from range
        FT.SEARCH itemIdx '@price:[(1000 +inf]'
        ```
        
        - bicycles with a price lower than or equal to 2000 USD (**`price <= 2000`**) by returning the five cheapest bikes:
        
        ```jsx
        FT.CREATE bikeIndex ON JSON PREFIX 1 bike: SCHEMA $.name AS name TEXT 
        SORTABLE $.price AS price NUMERIC $.color AS color TAG SORTABLE $.brand 
        AS brand TEXT SORTABLE
        
        FT.SEARCH bikeIndex '@price:[-inf 2000]' SORTBY price ASC LIMIT 0 5
        
        ```
        
- Full text
    - Single word
        - all bicycles that have the word 'kids' in the description:
        
        ```jsx
        FT.SEARCH itemIdx '@description: kids'
        ```
        
    - Word prefix (start with)
        - bicycles with a brand that starts with 'ka':
        
        ```jsx
        FT.SEARCH itemIdx '@model: ka*'
        ```
        
    - Word suffix (end with)
        - finds all brands that end with 'bikes':
        
        ```jsx
        FT.SEARCH itemIdx '@model: *bikes'
        ```
        
    - Fuzzy search (like SQL LIKE)
        - all documents that contain a word that has a distance of one to the incorrectly spelled word 'optamized’
            - You can see word ‘optamized’ is misspelled but its OK because we fuzzy search of %%, if u want to have most 2 incorrect 2 letters, use %%%%
        
        ```jsx
        FT.SEARCH idx:bicycle "%optamized%"
        FT.SEARCH idx:bicycle "%%optamised%%"
        ```
        
- Combined
    - AND
        - query that finds bicycles in new condition and in a price range from 500 USD to 1000 USD:
        
        ```jsx
        FT.SEARCH myidx '@price:[500 1000] @condition:{new}'
        FT.SEARCH myidx 'kids (@price:[500 1000] @condition:{used})'
        ```
        
    - OR
        
        ```jsx
        FT.SEARCH idx:bicycle "@description:(kids | small) @condition:{new | used}"
        ```
        
    - NOT
        - exclude new bicycles from the search within the previous price range
        
        ```jsx
        FT.SEARCH myidx '@price:[500 1000] -@condition:{new}'
        ```
        
- Aggregation
    - Simple mapping
        - how to calculate a discounted price for new bicycles:
        
        ```jsx
        
        ```
        
    - asdasd
    - asdasd