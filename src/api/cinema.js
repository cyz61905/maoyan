import request from '@/util/request.js'

export function getCinemaBrandList(){
  return request.get('cinema/cinemaNameList')
}

export function getCinemaLevelList(){
  return request.get('cinema/cinemaLevelList')
}

export function getCinemaList(brand,level,pageNum,pageSize){
  if(brand === '全部') brand = ''
  if(level === '全部') level = ''
  return request.get('cinema/list',{params: {brand,level,pageNum,pageSize}})
}

export function getCinemaById(id){
  return request.get(`cinema/${id}`)
}

export function getCinemaFilmSession(filmId, cinemaId){
  return request.get(`cinemaFilmSession/list?filmId=${filmId}&cinemaId=${cinemaId}`)
}
