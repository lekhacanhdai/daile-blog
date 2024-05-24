FROM python:3.11.8

WORKDIR /usr/app/src

COPY .env ./
COPY config.py ./
COPY debeziumconnector.py ./
COPY main.py ./
COPY requirements.txt ./

RUN python -m pip install --upgrade pip
RUN pip install -r requirements.txt

CMD ["python3", "main.py"]