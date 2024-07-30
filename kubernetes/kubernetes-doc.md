# kubectl cli commands

Para gerar um arquivo de configmap para o Postgres com base em nossos SQL scripts (execute na pasta raiz). Só precisa rodar de novo caso os scripts sejam atualizados

```
kubectl create configmap postgres-init-scripts --from-file=src/main/resources/sql_scripts/ -o yaml --dry-run=client > kubernetes/config-db.yaml
```

#### Os comandos abaixo devem ser executados na pasta do Kubernetes (`cd kubernetes`)]

Para aplicar nosso Secret

```
kubectl apply -f secrets.yaml
```

Para aplicar nosso ConfigMap

```
kubectl apply -f config-db.yaml
```

Para aplicar nosso PersistentVolume

```
kubectl apply -f pv-db.yaml
```

Para aplicar nosso PersistentVolumeClaim

```
kubectl apply -f pvc-db.yaml
```

Para aplicar nosso Deployment do banco de dados

```
kubectl apply -f deployment-db.yaml
```

Para aplicar nosso Service do banco de dados (aguarde o STATUS como "Running")

```
kubectl apply -f service-db.yaml
```

Para encaminhar a porta do serviço do banco de dados Postgres 5432 para nossa porta local 5432, para que possamos conectá-lo no DBeaver

```
kubectl port-forward svc/postgres 5432:5432
```

Para aplicar nosso Deployment do aplicativo

```
kubectl apply -f deployment-app.yaml
```

Para aplicar nosso Service do aplicativo

```
kubectl apply -f service-app.yaml
```

Para aplicar nosso HPA (Horizontal Pod Autoscaler) para autoescalar nossos pods

```
kubectl apply -f hpa-app.yaml
```

Para encaminhar a porta do serviço techfood-app 8080 para nossa porta local 8080, para enviar requisições no Postman (que está configurado para a porta 8080)

```
kubectl port-forward svc/techfood-app 8080:8080
```
