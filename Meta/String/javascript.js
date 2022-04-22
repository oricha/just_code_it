

function calculateDaysBetweenDates(begin, end) {
    var oneDay = 24*60*60*1000; // hours*minutes*seconds*milliseconds
    var firstDate = new Date(begin);
    var secondDate = new Date(end);
    var diffDays = Math.round(Math.abs((firstDate.getTime() - secondDate.getTime())/(oneDay)));
    return diffDays;
}

function randomNumber(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

//create a number that generate a random number between min and max
function randomNumberBetween(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

//create a function that generate QRCode
function generateQRCode(text, size, color, background) {
    var qrcode = new QRCode(document.getElementById("qrcode"), {
        text: text,
        width: size,
        height: size,
        colorDark : color,
        colorLight : background,
        correctLevel : QRCode.CorrectLevel.H
    });
}

//generate a funtion that create a pdf file
function createPDF(html, filename) {
    var doc = new jsPDF();
    doc.fromHTML(html, 15, 15, {
        'width': 170
    });
    doc.save(filename);
}

//create a function that upload a file to S3 bucket
function uploadFile(file, bucket, key) {
    var s3 = new AWS.S3();
    var params = {
        Bucket: bucket,
        Key: key,
        Body: file,
        ACL: 'public-read'
    };
    s3.upload(params, function (err, data) {
        if (err) {
            console.log(err);
        }
        console.log(data);
    });
}


