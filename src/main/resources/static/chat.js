'use strict';
const webSocketUrl = `ws://localhost:8080/chat-back-end`;
const client = new StompJs.Client({brokerURL: webSocketUrl});
let buttonSendMessage;
let sectionMessagesExchanged;
let buttonConnectToChat;
let buttonDisconnectToChat;


window.addEventListener(
    'load', () => {
        buttonSendMessage = document.getElementById('sendMessageButton');
        sectionMessagesExchanged = document.getElementById('sectionMessagesExchanged');
        buttonConnectToChat = document.getElementById('connectToChatButton');
        buttonDisconnectToChat = document.getElementById('disconnectToChatButton');

        buttonSendMessage.disabled = true;
        buttonConnectToChat.disabled = false;
        buttonDisconnectToChat.disabled = true;
    }
);

function connect() {
    client.activate();
    buttonSendMessage.disabled = false;
    buttonConnectToChat.disabled = true;
    buttonDisconnectToChat.disabled = false;
    clearMessagesExchanged();
}

function disconnect() {
    client.activate();
    buttonSendMessage.disabled = true;
    buttonConnectToChat.disabled = false;
    buttonDisconnectToChat.disabled = true;
    clearMessagesExchanged();
}

function clearMessagesExchanged() {
    sectionMessagesExchanged.innerHTML = "<tr><td colspan='2'>Empty!</td></tr>";
}