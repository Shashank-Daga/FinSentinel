from flask import Flask, request, jsonify
from model import predict_fraud

app = Flask(__name__)


@app.route("/predict", methods=["POST"])
def predict():
    data = request.json

    probability = predict_fraud(
        data["amount"],
        data["location"],
        data["merchantCategory"]
    )

    return jsonify({
        "fraudProbability": probability
    })


if __name__ == "__main__":
    app.run(port=5000)
