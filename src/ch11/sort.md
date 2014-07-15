merge sort

*divide the array into half and sort then recursively
*merge the two sorted halves togather to create a fully sorted array

nlgn worstcase
=>external sort



1. hashtable y
2. BST
3. mergeSort y
4. linkedlist y
===
Week 3 - 24-Dec-2012 - merge_sort.php
Write a function that merges an array of already sorted arrays, producing one large, still sorted array. For example, your input might be:

[[0, 5, 8, 9], [1, 2, 7], [10]]

And you should return:

[0, 1, 2, 5, 7, 8, 9, 10]

Week 2 - 17-Dec-2012 - check_binary_search_tree.php
Write a function that returns whether a given binary tree is a valid binary search tree. Use your favorite programming language. For extra credit, write your response on paper or your gigantic Mark Zuckerberg-approved whiteboard. You likely won't have an IDE at your next interview.

Week 1 - 10-Dec-2012 - hash_table.php
For this week, take a stab at implementing a hash table in your favorite programming language. That is to say, write a data structure that will let you map keys to values and give you amortized constant-time access. Your implementation should have some form of collision handling--what do you do when your hash function maps two keys to the same place?

This is a game of taboo—don't use any associative arrays (dictionaries, hash.*s, {}s, PHP array(k=>v)s etc) in your implementation. Time yourself, and time box your attempt to one hour. As Yegge notes: "You should be able to implement one using only arrays in your favorite language, in about the space of one interview."

https://github.com/jmdobry/codingforinterviews
==============
Quotes of the Week
“Shouldn’t you just be able to go in cold? Sure! You can do whatever you want. The question is, do you want to use The Hope Method™, or do you want to give yourself the best possible chance at a process that will ultimately determine how you spend the majority of your waking hours for the next couple of years?” - Daniel Blumenthal, How to prepare for technical interviews

"You’re looking for people who are (1) Smart, and (2) Get things done." - Joel Spolsky, The Guerilla Guide to Interviewing

“After the programming test, they told me it was obvious that I was intelligent, but also that I was self-taught. […] That kind of woke me up. Ever since, I’ve been working on improving my coding skill.” - Markus “Notch” Persson, Coding skill and the decline of stagnation

“Another effective technique is to explain your code to someone else. This will often cause you to explain the bug to yourself.” - Brian Kernighan and Rob Pike, The Practice of Programming

Interviewing links of the Week
Teach Yourself Programming in Ten Years - Long term CS career advice from Peter Norvig, author of the AI bible
“Hacking a Google Interview” 2009 MIT IAP course notes
Typing.io - Learn good programming style by typing out good code
Preparing your resumé - Tricks and tips from a Google recruiter. Something it takes all of us way too long to learn—fill your resumé with specifics about what you personally did on a project
This week’s topic: Merge Sort
[![]][]

Why review merge sort?
From a piece on preparing for technical interviews by Dan Blumenthal, Director of Engineering at TripAdvisor:

“You’ll likely be asked about algorithms and complexity theory. If someone asks you to name a sorting algorithm,”bubble sort" shouldn’t be your first answer."

A quick Google search reveals that sorting and merging questions have been spotted at Amazon, Palantir and Twitter.

What you need to know
Merge sort (CLRS chapter 2) is one of the few sorting algorithms you may need to implement during a coding interview. Other likely candidates are quicksort and insertion sort, which will be covered in future emails.

The concept is simple: Define a recursive function that (1) divides an array in half, (2) calls itself to sort both halves separately, and (3) merges the two resultant arrays after. Once the two sorted halves have been shuffled together, return the resulting array.

Some things to keep in mind:

The average and worst-case time complexities of merge sort are O(n log n). If you have a pre-processing check to see if the list is already sorted, you could have a best case of O(n). But in the words of MIT professor Charles Leiserson, best cases are pretty “bogus”.
Merge sort implementations are usua TRUNCATED! Please download pandoc if you want to convert large files.
Sorting, in general, takes at least O(n log n) time—the fastest sorting algorithm in existence that handles arbitrary data would take O(n log n) time.
Here are some steps you should take toward gaining a deep understanding of merge sort:

[![][]][]

If you have never heard of Merge Sort, you should set aside the 50 minutes to watch this [MIT Charles Leiserson video lecture on Merge Sort][![][]] or read these course notes from a McGill lecture.
Read about the time / space complexity tradeoffs of merge sort, (and check out those merge sort animations!): http://www.sorting-algorithms.com/merge-sort
Look up how to do a merge sort in-place, without using any extra memory.
Problem of the week - Holiday Edition
We’re having so much fun merging arrays of numbers, why stop now!

For this week, complete these tasks:

Explain what merge sort is and what to consider when implementing it.
Explain how Santa Claus might use merge sort to help with Christmas (extra points for mental gymnastics).
Write a function that merges an array of already sorted arrays, producing one large, still sorted array. Use your favorite programming language. For extra credit, write your response on paper or your gigantic Mark Zuckerberg-approved whiteboard. You likely won’t have an IDE at your next interview.
For example, your input might be:

[[0, 5, 8, 9], [1, 2, 7], [10]]
And you should return:

[0, 1, 2, 5, 7, 8, 9, 10]
Give it a spin, write some code, limit yourself to one hour and submit your code. There are a few different approaches you could take to organize your solution.

What is the runtime complexity of your solution? How about space? Do you think there could be faster or more space efficient solutions?