

function solution(N, A) {
    var j;
    var i;
    var len = A.length;
    var lastMax = 0;
    var max = 0;
    var counters = new Array(N).fill(0);
    var n1 = N + 1;

    for (j = 0; j < len; j++) {
        if (A[j] < n1) {
            i = A[j] - 1;
            if (counters[i] < lastMax) counters[i] = lastMax;
            counters[i]++;
            if (max < counters[i]) max = counters[i];
        } else {
            lastMax = max;
        }
    }

    for (j = 0; j < N; j++) {
        if (counters[j] < lastMax) counters[j] = lastMax;
    }

    return counters;
}
