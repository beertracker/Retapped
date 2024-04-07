// import SearchBarComponent from "./SearchBarComponent"

/* LIBRARIES */
import "./App.css"

import {
  Box,
  Button,
  ButtonGroup,
  Flex,
  HStack,
  IconButton,
  Input,
  SkeletonText,
  Text,
} from "@chakra-ui/react"
import { FaLocationArrow, FaTimes } from "react-icons/fa"

import {
  useJsApiLoader,
  GoogleMap,
  Marker,
  Autocomplete,
  DirectionsRenderer,
} from "@react-google-maps/api"
import { useRef, useState, useEffect } from "react"

/* CONST VARIABLES */
const googleMapsApiKey = process.env.REACT_APP_GOOGLE_MAPS_API_KEY // Receive api from .env file in src/main/frontend
const center = { lat: 39.77989349393462, lng: -84.06510220325708 } // default location to WSU

/* MAIN COMPONENT */
function App() {
  const [setVendors] = useState([])

  // Loads in google maps script to display map with libraries(react-google-maps/api)
  const { isLoaded } = useJsApiLoader({
    googleMapsApiKey: googleMapsApiKey,
    libraries: ["places", "routes", "core", "maps", "geocoding", "marker"],
  })

  // React hook: Initial Map State
  const [map, setMap] = useState(null)

  // Ensure the script and map are loaded and calls fetchNearbyVendors
  useEffect(() => {
    if (isLoaded && map) {
      fetchNearbyVendors()
    }
  })
  // React hooks: Initial states for distaance, directions, and travel time
  const [directionsResponse, setDirectionsResponse] = useState(null)
  const [distance, setDistance] = useState("")
  const [duration, setDuration] = useState("")
  const originRef = useRef()
  const destinationRef = useRef()

  //** if script is not load display the "skeleton" text */
  if (!isLoaded) {
    return <SkeletonText />
  }

  async function CalculateRoute() {
    if (originRef.current.value === "" || destinationRef.current.value === "") {
      return
    }
    // eslint-disable-next-line no-undef
    const directionsService = new google.maps.DirectionsService() // Initialize directionService object using Gmaps API
    const results = await directionsService.route({
      // wait for directionService and then Initialize results
      origin: originRef.current.value,
      destination: destinationRef.current.value,
      // eslint-disable-next-line no-undef
      travelMode: google.maps.TravelMode.DRIVING, // Mode: Walk, Bus, Drive, Etc.
    })

    // Update the states of each hook
    setDirectionsResponse(results)
    setDistance(results.routes[0].legs[0].distance.text)
    setDuration(results.routes[0].legs[0].duration.text)
  }

  // Search for nearby liquor stores (**WIP**)
  const fetchNearbyVendors = () => {
    // If not loaded, return
    if (!isLoaded || !map) return

    // Places API object
    const liqourService = new window.google.maps.places.PlacesService(map)

    // Search for specific types of stores with defined distance
    liqourService.nearbySearch(
      {
        location: center,
        radius: "10000",
        type: ["liquor_store"],
      },

      // checks results and status to displays an error msg in console if any issues occur
      (results, status) => {
        if (
          status === window.google.maps.places.PlacesServiceStatus.OK &&
          results
        ) {
          setVendors(results)
        } else {
          console.error("Places Service failed:", status)
        }
      }
    )
  }

  // Resets directions, distance, and travel time
  function ClearRoute() {
    setDirectionsResponse(null)
    setDistance("")
    setDuration("")
    originRef.current.value = ""
    destinationRef.current.value = ""
  }

  /* UI LAYOUT */
  return (
    <Flex
      position="relative"
      flexDirection="column"
      alignItems="center"
      h="100vh"
      w="100vw">
      <Box position="absolute" left={0} top={0} h="100%" w="100%">
        {/* Google Map Box */}
        <GoogleMap
          center={center}
          zoom={15}
          mapContainerStyle={{ width: "100%", height: "100%" }}
          options={{
            zoomControl: false,
            streetViewControl: false,
            mapTypeControl: false,
            fullscreenControl: false,
          }}
          // Set Map to the center variable Lat/Long
          onLoad={(map) => setMap(map)}>
          <Marker position={center} />
          {directionsResponse && (
            <DirectionsRenderer directions={directionsResponse} />
          )}
        </GoogleMap>
      </Box>
      <Box
        /* Interactive Box */
        p={4}
        borderRadius="lg"
        m={4}
        bgColor="white"
        shadow="base"
        minW="container.md"
        zIndex="modal">
        {/* text Autocomplete component functionality  */}
        <HStack spacing={2} justifyContent="space-between">
          <Box flexGrow={1}>
            <Autocomplete>
              <Input type="text" placeholder="Origin" ref={originRef} />
            </Autocomplete>
          </Box>
          <Box flexGrow={1}>
            <Autocomplete>
              <Input
                type="text"
                placeholder="Destination"
                ref={destinationRef}
              />
            </Autocomplete>
          </Box>
          {/* Calculate route button*/}
          <ButtonGroup>
            <Button colorScheme="pink" type="submit" onClick={CalculateRoute}>
              Calculate Route
            </Button>
            <IconButton
              aria-label="center back"
              icon={<FaTimes />}
              onClick={ClearRoute}
            />
          </ButtonGroup>
        </HStack>
        <HStack spacing={4} mt={4} justifyContent="space-between">
          <Text>Distance: {distance} </Text>
          <Text>Duration: {duration} </Text>
          {/* navigator button takes user to center variable (WSU) */}
          <IconButton
            aria-label="center back"
            icon={<FaLocationArrow />}
            isRound
            onClick={() => {
              map.panTo(center)
              map.setZoom(15)
            }}
          />
        </HStack>
      </Box>
    </Flex>
  )
}

export default App
