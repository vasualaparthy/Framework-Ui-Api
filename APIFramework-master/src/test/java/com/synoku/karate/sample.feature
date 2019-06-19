Feature: Sample feature

@simpleget
Scenario: Testing valid GET endpoint
Given url 'https://jsonplaceholder.typicode.com/todos/1'
When method GET
Then status 200

@ignore
Scenario: Testing the exact response of a GET endpoint
Given url 'https://jsonplaceholder.typicode.com/todos/1'
When method GET
Then status 200
And match $ == { "userId": 1,"id": 1,"title": "delectus aut autem","completed": false }
And match $.userId == 1
And match $ contains {"userId": 1}
And match $ == { "userId": #notnull,"id": 1,"title": "delectus aut autem","completed": false }
And match $.title == "delectus aut autem"

@ignore
Scenario: Printing the exact response of a GET endpoint
Given url 'https://jsonplaceholder.typicode.com/todos/1'
When method GET
Then status 200
* def res = response
* print 'res:', res

@create
Scenario: Create Post Call
Given url 'https://jsonplaceholder.typicode.com/posts'
And request { title: 'foo', body: 'bar', userId: 1}
When method POST
Then status 201
* def resi = response
* print 'res:', resi

 @invokejavacode
Scenario: Printing the exact response of a GET endpoint
Given url 'https://jsonplaceholder.typicode.com/todos/1'
When method GET
Then status 200
Given def JavaDemo = Java.type('com.synoku.javacode.JavaDemo')
When def res = response
And def result = JavaDemo.doWorkStatic(res)
Then print result
