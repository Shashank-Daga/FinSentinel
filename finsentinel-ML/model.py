import numpy as np


def predict_fraud(amount, location, merchant):
    risk = 0

    if amount >= 40000:
        risk += 0.5

    if merchant == "GAMBLING":
        risk += 0.3

    if location != "India":
        risk += 0.2

    return min(risk, 1.0)
