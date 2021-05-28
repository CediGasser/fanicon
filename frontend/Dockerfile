FROM nginx
RUN rm /etc/nginx/conf.d/default.conf
COPY ./html/ /etc/nginx/html/
COPY ./nginx/nginx.conf /etc/nginx/conf.d/default.conf