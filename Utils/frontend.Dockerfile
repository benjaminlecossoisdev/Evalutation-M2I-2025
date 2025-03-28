FROM nginx:alpine
COPY ../FrontEnd/index.html /usr/share/nginx/html/
EXPOSE 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]