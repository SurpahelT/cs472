function max(a, b) {
    return a > b ? a : b;
}

function maxOfThree(a, b, c) {
    return max(max(a, b), c);
}

function isVowel(char) {
    return 'aeiouAEIOU'.includes(char);
}

function sum(numbers) {
    return numbers.reduce((acc, curr) => acc + curr, 0);
}

function multiply(numbers) {
    return numbers.reduce((acc, curr) => acc * curr, 1);
}

function reverse(str) {
    return str.split('').reverse().join('');
}

function findLongestWord(words) {
    return words.reduce((maxLen, word) => Math.max(maxLen, word.length), 0);
}

function filterLongWords(words, i) {
    return words.filter(word => word.length > i);
}

function myFunctionTest(expected, func) {
    const result = func();
    if (expected === result) {
        return "TEST SUCCEEDED";
    } else {
        return "TEST FAILED";
    }
}

// Test cases
console.log("Expected output of max(20, 10) is 20 and " + myFunctionTest(20, function(){return max(20, 10);}));
console.assert(max(20, 10) === 20, "TEST FAILED");

console.log("Expected output of maxOfThree(5, 4, 44) is 44 and " + myFunctionTest(44, function(){return maxOfThree(5, 4, 44);}));
console.assert(maxOfThree(5, 4, 44) === 44, "TEST FAILED");

console.log("Expected output of isVowel('a') is true and " + myFunctionTest(true, function(){return isVowel('a');}));
console.assert(isVowel('a') === true, "TEST FAILED");

console.log("Expected output of sum([1, 2, 3, 4]) is 10 and " + myFunctionTest(10, function(){return sum([1, 2, 3, 4]);}));
console.assert(sum([1, 2, 3, 4]) === 10, "TEST FAILED");

console.log("Expected output of multiply([1, 2, 3, 4]) is 24 and " + myFunctionTest(24, function(){return multiply([1, 2, 3, 4]);}));
console.assert(multiply([1, 2, 3, 4]) === 24, "TEST FAILED");

console.log("Expected output of reverse('suraphel tilahun') is 'nuhalit lehparus' and " + myFunctionTest('nuhalit lehparus', function(){return reverse('suraphel tilahun');}));
console.assert(reverse('suraphel tilahun') === 'nuhalit lehparus', "TEST FAILED");

console.log("Expected output of findLongestWord(['apple', 'banana', 'cherry']) is 6 and " + myFunctionTest(6, function(){return findLongestWord(['apple', 'banana', 'cherry']);}));
console.assert(findLongestWord(['apple', 'banana', 'cherry']) === 6, "TEST FAILED");

console.log("Expected output of filterLongWords(['apple', 'banana', 'cherry'], 5) is ['banana', 'cherry'] and " + myFunctionTest(['banana', 'cherry'].toString(), function(){return filterLongWords(['apple', 'banana', 'cherry'], 5).toString();}));
console.assert(filterLongWords(['apple', 'banana', 'cherry'], 5).toString() === ['banana', 'cherry'].toString(), "TEST FAILED");

const a = [1,3,5,3,3];
const multipliedBy10 = a.map(num => num * 10);
const equalTo3 = a.filter(num => num === 3);
const productOfAll = a.reduce((acc, num) => acc * num, 1);

console.log("Array multiplied by 10: " + multipliedBy10);
console.log("Array elements equal to 3: " + equalTo3);
console.log("Product of all elements: " + productOfAll);