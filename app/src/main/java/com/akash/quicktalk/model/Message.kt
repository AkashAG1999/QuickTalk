package com.akash.quicktalk.model

class Message {

    var messageID : String? = null;
    var message : String? = null;
    var senderID : String? = null;
    var imageUrl : String? = null;
    var timeStamp : Long = 0;
    constructor(){}
    constructor(
        message : String?,
        senderID : String?,
        timeStamp : Long
    ){
        this.message = message
        this.senderID = senderID
        this.timeStamp = timeStamp
    }





}