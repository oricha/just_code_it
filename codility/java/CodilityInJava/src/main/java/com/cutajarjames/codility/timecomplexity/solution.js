// you can write to stdout for debugging purposes, e.g.
// console.log('this is a debug message');

function solution(Array) {
    // write your code in JavaScript (Node.js 4.0.0)
    var lower = [Array.length];
    var upper = [Array.length];

    lower.push(0);

    for (var i = 0; i < Array.length; i++) {
        var iRev = Array.length - i - 1;

        if (i === 0) {
            lower[i] = 0;
        } else {
            lower[i] = lower[i - 1] + Array[i - 1];
        }

        if (iRev === Array.length - 1) {
            upper[iRev] = Array[iRev];
        } else {
            upper[iRev] = upper[iRev + 1] + Array[iRev];
        }
    }

    var result = Math.abs(lower[1] - upper[1]);

    for (var i = 2; i < lower.length; i++) {
        var diff = Math.abs(lower[i] - upper[i]);
        if (diff < result) {
            result = diff;
        }
    }

    return result;
}
