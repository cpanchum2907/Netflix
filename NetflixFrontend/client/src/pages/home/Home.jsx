import Toolbar from "../../components/toolbar/Toolbar"
import Featured from "../../components/featured/Featured"
import List from "../../components/list/List"
import requests from "../../Requests"
import "./home.scss"

const Home = () => {
  return (
    <div className="home">
      <Toolbar/>
      <Featured/>    
      <List title='Continue to watch' fetchURL={requests.requestUpcoming} />

    <List title='Popular' fetchURL={requests.requestPopular}/>

    <List title='Trending' fetchURL={requests.requestTrending}/>

    <List title='TopRated' fetchURL={requests.requestTopRated}/>

    <List title='Horror' fetchURL={requests.requestHorror}/>
    </div>
  )
}

export default Home
