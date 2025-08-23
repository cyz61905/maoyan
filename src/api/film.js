import request from '@/util/request.js'

export function getTop100FilmList() {
  return request.get('film/top100')
}

export function getHomepageFilmList() {
  return request.get('film/homepage')
}

export function getFilmDetail(id) {
  return request.get(`film/${id}`)
}

export function getUserIsWant(filmId, userId){
  return request.get(`user-want-film/find?filmId=${filmId}&userId=${userId}`)
}

export function userWantFilm(filmId, userId){
  return request.post(`user-want-film/want`, {filmId, userId})
}

export function userUnWantFilm(filmId, userId){
  return request.delete(`user-want-film/delete?filmId=${filmId}&userId=${userId}`)
}

export function getFilmComment(filmId,pageNum,pageSize){
  return request.get(`comment/list?filmId=${filmId}&pageNum=${pageNum}&pageSize=${pageSize}`)
}

export function addComment(content,score,filmId,userId){
  return request.post(`comment/add`, {content,score,filmId,userId})
}

export function getFilmTypeList() {
  return request.get('type/list?pageSize=30')
}

export function getRegionList() {
  return request.get('region/list?pageSize=30')
}

export function getFilmList(typeId,regionId,year,sort,pageNum,pageSize){
  return request.get(`film/list?typeId=${typeId}&regionId=${regionId}&year=${year}&sort=${sort}&pageNum=${pageNum}&pageSize=${pageSize}`)
}
