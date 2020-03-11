const mongoose = require("mongoose");

const JokeSchema = new mongoose.Schema({
	title: String,
	riddle: String,
	answer: String
});

const Joke = mongoose.model("joke", JokeSchema);

module.exports = Joke;