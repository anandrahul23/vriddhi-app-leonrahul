import './App.css'
import CustomTabs from './modules/CustomTabs' 
import {type CustomTabsProps} from './modules/CustomTabs.tsx'

function App() {
 // const [count, setCount] = useState(0)

 //Use the CustomTabsProps interface to pass the required props to the CustomTabs component
  const tabProps: CustomTabsProps = {
    title: 'Watchlist',
    watchlists: [
      {
        title: 'Tech',
        shares: [
          {
            name: 'Apple',
            price: 150,
            exchange: 'NASDAQ',
            symbol: 'AAPL',
            description: 'Apple Inc. designs, manufactures, and markets smartphones, personal computers, tablets, wearables, and accessories worldwide.'
          },
          {
            name: 'Microsoft',
            price: 300,
            exchange: 'NASDAQ',
            symbol: 'MSFT',
            description: 'Microsoft Corporation develops, licenses, and supports software, services, devices, and solutions worldwide.'
          }
        ]
      },
      {
        title: 'Healthcare',
        shares: [
          {
            name: 'Pfizer',
            price: 40,
            exchange: 'NYSE',
            symbol: 'PFE',
            description: 'Pfizer Inc. discovers, develops, manufactures, markets, distributes, and sells biopharmaceutical products worldwide.'
          },
          {
            name: 'Johnson & Johnson',
            price: 150,
            exchange: 'NYSE',
            symbol: 'JNJ',
            description: 'Johnson & Johnson researches and develops, manufactures, and sells various products in the health care field worldwide.'
          }
        ]
      }
    ],
    content: undefined
  }

  return (
    <>
         <CustomTabs title={tabProps.title} watchlists={tabProps.watchlists} content = {<p>{tabProps.content}</p>}/>
    </>
  )
}

export default App
