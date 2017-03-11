$(document).ready(function() {

	$("#i").click(function(event) {
		var i = $("#w");
		getPuk('getpuk', i.val(), $("#en"));
	});

	$("#d").click(function(event) {
		decode($('#en').text(), $('#de'));
	});

});

var puk;

function getPuk(url, val, doc) {


	$.ajax({
			url: url,
			type: 'POST',
			// dataType: 'json',
			// data: {param1: 'value1'},
			// success: function(result) {
			// 	console.log(e);
			// 	puk = e;
			// 	return encode(puk, val);
			// }
		})
		.done(function(e) {
			console.log(e);
			var encrypt = new JSEncrypt();
			encrypt.setPublicKey(e);
 			var encrypted = encrypt.encrypt(val);
 			// var en =linebrk(hex2b64(encrypted),64);
 			var en = encrypted;
 			console.log(en);
			doc.text(en);
		})
		.fail(function(e) {
			console.log(e);
			alert('服务器错误');
		})
}

// function encode(key, val) {
// 	var res;
// 	var rsa = new RSAKey();
// 	// var keyh = b64tohex(key);
// 	var keyh = key;
// 	console.log("kh=" + keyh);
// 	rsa.setPublic(keyh, "10001");
// 	res = linebrk(hex2b64(rsa.encrypt(val)), 64);
// 	// res = rsa.encrypt(val)
// 	console.log('rsa=' + res);
// 	return res;
// }

function decode(mi, doc) {
	$.ajax({
			url: 'decode',
			type: 'post',
			// dataType: 'default: Intelligent Guess (Other values: xml, json, script, or html)',
			data: {
				k: mi
			},
		})
		.done(function(e) {
			console.log(e);
			doc.text(e);
		})
		.fail(function() {
			console.log("error");
		})
		.always(function() {
			console.log("complete");
		});

}