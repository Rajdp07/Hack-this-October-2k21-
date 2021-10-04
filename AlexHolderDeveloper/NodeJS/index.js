let userInfo = require("os").userInfo();
let deviceInfo = require("os").platform();

console.log(`Hello there, ${userInfo.username}! `);
console.log(`Information about your user profile includes: ${JSON.stringify(userInfo)}`);
console.log(`It looks like your operating system is: ${deviceInfo}, though this may be slightly-false if you're using a virtual machine or container or even WSL!`);