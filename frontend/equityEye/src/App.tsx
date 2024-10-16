import './App.css'
import CustomTabs from './modules/CustomTabs' 
import tabProps from './data/TabData'

function App() {
 // const [count, setCount] = useState(0)

 

  return (
    <>
         <CustomTabs title={tabProps.title} watchlists={tabProps.watchlists} content = {<p>{tabProps.content}</p>}/>
    </>
  )
}

export default App
