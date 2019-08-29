
exports.testHttp= function(host) {
    var httpClient = require('http');
    var options = {
        host:host,
        port:'80',
        method:'get'
    };


    var req = httpClient.request(options, function (res) {
        res.setEncoding('utf8');
        res.on('data', function (chunk) {
            countDown();
        });
    });
    req.on('error', function (e) {
        console.log('problem with request: ' + e.message);
    });
    req.end();

}
