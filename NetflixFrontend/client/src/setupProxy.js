const { createProxyMiddleware } = require('http-proxy-middleware');



module.exports = function(app) {
  app.use(createProxyMiddleware('/netflixJava', { target: 'http://localhost:8080/netflix/',changeOrigin: true, pathRewrite: { '^/netflixJava': '' } }));
};