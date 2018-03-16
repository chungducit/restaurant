var gulp = require('gulp');
var sass = require('gulp-sass');
var rename = require('gulp-rename');
var webpack = require('webpack-stream');
var connect = require('gulp-connect');

var BUILD_DIR = 'src/main/resources/static/';
var APP_DIR = 'src/main/';

gulp.task('app', function () {
    gulp.src(APP_DIR + 'javascript/app.jsx')
        .pipe(webpack({
            module: {
                loaders: [
                    {
                        loader: 'babel-loader',
                        exclude: /node_modules/,
                        query: {
                            presets: ['es2015', 'react']
                        }
                    }
                ]
            }
        }))
        .pipe(rename('bundle.js'))
        .pipe(gulp.dest(BUILD_DIR + 'js'))
    ;
});

gulp.task('item', function () {
    gulp.src(APP_DIR + 'javascript/item.jsx')
        .pipe(webpack({
            module: {
                loaders: [
                    {
                        loader: 'babel-loader',
                        exclude: /node_modules/,
                        query: {
                            presets: ['es2015', 'react']
                        }
                    }
                ]
            }
        }))
        .pipe(rename('item_bundle.js'))
        .pipe(gulp.dest(BUILD_DIR + 'js'))
    ;
});

gulp.task('styles', function () {
    gulp.src(APP_DIR + 'scss/app.scss')
        .pipe(sass())
        .pipe(gulp.dest(BUILD_DIR + 'css'));
});

/* gulp.task('connect', function() {
  connect.server({
    root: '.',
    livereload: true
  })
}); */

gulp.task('watch', function() {
  gulp.watch(APP_DIR + 'javascript/app.jsx', ['app']);
  gulp.watch(APP_DIR + 'javascript/item.jsx', ['item']);
  
  gulp.watch(APP_DIR + 'scss/*.scss', ['styles']);
});

gulp.task('default', ['app', 'item', 'styles', 'watch']);
