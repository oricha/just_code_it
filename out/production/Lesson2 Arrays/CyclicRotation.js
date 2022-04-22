function solution(A, K) {
    K = K % A.length;
    if (A.length < 2 || K === 0) {
        return A;
    }

    var part = A.splice(A.length - K);
    return part.concat(A);
}
