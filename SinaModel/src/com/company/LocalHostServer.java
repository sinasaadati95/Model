package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class LocalHostServer implements Runnable {

    private Thread engine = null ;

    public LocalHostServer(){
        this.engine = new Thread(this);
        this.engine.start();
    }

    private boolean alive = true ;

    @Override
    public void run() {
        while(this.alive){
            try{
                this.listenForClient();
            }catch (IOException ex){
                System.err.println(ex.toString());
            }
        }
    }


    private void listenForClient() throws IOException {
        ServerSocket server = new ServerSocket(1402);
        while(this.alive){
            Socket channel = server.accept();
            System.out.println("New Client connected.");
            OutputStream os = new DataOutputStream(channel.getOutputStream());
            os.write(this.generateCode().getBytes("UTF-8"));
            os.close();
            channel.close();
        }
    }


    private String generateCode(){
        return ( this.getProtocol() + this.getHTMLdocument() ) ;
    }

    private String getProtocol(){
        return ( "HTTP/1.1 200 OK\r\n\r\n" ) ;
    }

    private String getHTMLdocument(){
        return this.HTMLcode ;
    }

    private String HTMLcode = "<!DOCTYPE html>\n" +
            "<html lang=\"en\" class=\"no-js\">\n" +
            "\t<head>\n" +
            "\t\t<meta charset=\"UTF-8\" />\n" +
            "\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "\t\t<title>Sina Saadati .::!::. Model Viewer</title>\n" +
            "\t\t\n" +
            "\t\t\n" +
            "\t\t<meta name=\"author\" content=\"SinaSaadati\" />\n" +
            "\t\t<script>document.documentElement.className=\"js\";var supportsCssVars=function(){var e,t=document.createElement(\"style\");return t.innerHTML=\"root: { --tmp-var: bold; }\",document.head.appendChild(t),e=!!(window.CSS&&window.CSS.supports&&window.CSS.supports(\"font-weight\",\"var(--tmp-var)\")),t.parentNode.removeChild(t),e};supportsCssVars()||alert(\"Please view this demo in a modern browser that supports CSS Variables.\");</script>\n" +
            "\t</head>\n" +
            "\t<body >\n" +
            "\t\t<div class=\"loading\" id=\"js-loader\">\n" +
            "\t\t\t<div class=\"loader\"></div>\n" +
            "\t\t</div>\n" +
            "\t\t<div class=\"wrapper\">\n" +
            "\t\t    <!-- The canvas element is used to draw the 3D scene -->\n" +
            "\t\t\t<canvas id=\"c\"></canvas>\n" +
            "\t\t</div>\n" +
            "\t\t<!-- The main Three.js file -->\n" +
            "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n" +
            "\t\t<script src='https://cdnjs.cloudflare.com/ajax/libs/three.js/108/three.min.js'></script>\n" +
            "\t\t<!-- This brings in the ability to load custom 3D objects in the .gltf file format. Blender allows the ability to export to this format out the box -->\n" +
            "\t\t<script src='https://cdn.jsdelivr.net/gh/mrdoob/Three.js@r92/examples/js/loaders/GLTFLoader.js'></script>\n" +
            "\t\t<!-- partial -->\n" +
            "\t\t<script >\n" +
            "\n" +
            "            (function () {\n" +
            "                // Set our main variables\n" +
            "                let scene,\n" +
            "                renderer,\n" +
            "                camera,\n" +
            "                model, // Our character\n" +
            "                neck, // Reference to the neck bone in the skeleton\n" +
            "                waist, // Reference to the waist bone in the skeleton\n" +
            "\t\t        leftShoulder , //Reference to the left shoulder bone in the skeleton\n" +
            "\t\t        rightShoulder , //Reference to the right shoulder bone in the skeleton\n" +
            "\t\t        leftElbow , //Reference to the left elbow bone in the skeleton\n" +
            "\t\t        rightElbow , //Reference to the right elbow bone in the skeleton\n" +
            "\t\t        leftWrist , //Reference to the left wrist bone in the skeleton\n" +
            "\t\t        rightWrist , //Reference to the right wrist bone in the skeleton\n" +
            "\t\t        leftThigh , //Reference to the left elbow bone in the skeleton\n" +
            "\t\t        rightThigh , //Reference to the right elbow bone in the skeleton\n" +
            "\t\t        leftKnee , //Reference to the left elbow bone in the skeleton\n" +
            "\t\t        rightKnee , //Reference to the right elbow bone in the skeleton\n" +
            "\t\t        leftAnkle , //Reference to the left elbow bone in the skeleton\n" +
            "\t\t        rightAnkle , //Reference to the right elbow bone in the skeleton\n" +
            "                possibleAnims, // Animations found in our file\n" +
            "                mixer, // THREE.js animations mixer\n" +
            "                idle, // Idle, the default state our character returns to\n" +
            "                clock = new THREE.Clock(), // Used for anims, which run to a clock instead of frame rate \n" +
            "                currentlyAnimating = false, // Used to check whether characters neck is being used in another anim\n" +
            "                raycaster = new THREE.Raycaster(), // Used to detect the click on our character\n" +
            "                loaderAnim = document.getElementById('js-loader');\n" +
            "\n" +
            "                init();\n" +
            "\n" +
            "                function init() {\n" +
            "\n" +
            "                    const MODEL_PATH = 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/1376484/stacy_lightweight.glb';\n" +
            "                    const canvas = document.querySelector('#c');\n" +
            "                    const backgroundColor = 0xf1f1f1;\n" +
            "\n" +
            "                    // Init the scene\n" +
            "                    scene = new THREE.Scene();\n" +
            "                    scene.background = new THREE.Color(backgroundColor);\n" +
            "                    scene.fog = new THREE.Fog(backgroundColor, 60, 100);\n" +
            "\n" +
            "                    // Init the renderer\n" +
            "                    renderer = new THREE.WebGLRenderer({ canvas, antialias: true });\n" +
            "                    renderer.shadowMap.enabled = true;\n" +
            "                    renderer.setPixelRatio(window.devicePixelRatio);\n" +
            "                    document.body.appendChild(renderer.domElement);\n" +
            "\n" +
            "                    // Add a camera\n" +
            "                    camera = new THREE.PerspectiveCamera(\n" +
            "                    50,\n" +
            "                    window.innerWidth / window.innerHeight,\n" +
            "                    0.1,\n" +
            "                    1000);\n" +
            "\n" +
            "                    camera.position.z = 30;\n" +
            "                    camera.position.x = 0;\n" +
            "                    camera.position.y = -3;\n" +
            "\n" +
            "                    let stacy_txt = new THREE.TextureLoader().load('https://s3-us-west-2.amazonaws.com/s.cdpn.io/1376484/stacy.jpg');\n" +
            "                    stacy_txt.flipY = false;\n" +
            "\n" +
            "                    const stacy_mtl = new THREE.MeshPhongMaterial({\n" +
            "                        map: stacy_txt,\n" +
            "                        color: 0xffffff,\n" +
            "                        skinning: true });\n" +
            "\n" +
            "\n" +
            "\n" +
            "                    var loader = new THREE.GLTFLoader();\n" +
            "\n" +
            "                    loader.load(\n" +
            "                    MODEL_PATH,\n" +
            "                    function (gltf) {\n" +
            "                        model = gltf.scene;\n" +
            "                        let fileAnimations = gltf.animations;\n" +
            "\n" +
            "                        model.traverse(o => {\n" +
            "\n" +
            "                            if (o.isMesh) {\n" +
            "                           \t o.castShadow = true;\n" +
            "                       \t\t o.receiveShadow = true;\n" +
            "                        \t o.material = stacy_mtl;\n" +
            "                    \t    }\n" +
            "                        // Reference the neck and waist bones\n" +
            "                        if (o.isBone && o.name === 'mixamorigNeck') {\n" +
            "                            neck = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigSpine') {\n" +
            "                            waist = o;\n" +
            "                        }\n" +
            "\n" +
            "                        if (o.isBone && o.name === 'mixamorigLeftShoulder') {\n" +
            "                            leftShoulder = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigRightShoulder') {\n" +
            "                            rightShoulder = o;\n" +
            "                        }\n" +
            "\n" +
            "\n" +
            "                        if (o.isBone && o.name === 'mixamorigLeftArm') {\n" +
            "                            leftElbow = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigRightArm') {\n" +
            "                            rightElbow = o;\n" +
            "                        }\n" +
            "\n" +
            "\n" +
            "                        if (o.isBone && o.name === 'mixamorigLeftHand') {\n" +
            "                            leftWrist = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigRightHand') {\n" +
            "                            rightWrist = o;\n" +
            "                        }\n" +
            "\n" +
            "\n" +
            "                        if (o.isBone && o.name === 'mixamorigLeftUpLeg') {\n" +
            "                            leftThigh = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigRightUpLeg') {\n" +
            "                            rightThigh = o;\n" +
            "                        }\n" +
            "\n" +
            "\n" +
            "                        if (o.isBone && o.name === 'mixamorigLeftLeg') {\n" +
            "                            leftKnee = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigRightLeg') {\n" +
            "                            rightKnee = o;\n" +
            "                        }\n" +
            "\n" +
            "\n" +
            "                        if (o.isBone && o.name === 'mixamorigLeftFoot') {\n" +
            "                            leftAnkle = o;\n" +
            "                        }\n" +
            "                        if (o.isBone && o.name === 'mixamorigRightFoot') {\n" +
            "                            rightAnkle = o;\n" +
            "                        }\n" +
            "\n" +
            "\n" +
            "\t\t\tconsole.log(o.name);\n" +
            "                });\n" +
            "\n" +
            "                model.scale.set(7, 7, 7);\n" +
            "                model.position.y = -11;\n" +
            "\n" +
            "                scene.add(model);\n" +
            "\n" +
            "                loaderAnim.remove();\n" +
            "\n" +
            "                setTimeout(start , 5000);\n" +
            "\n" +
            "                mixer = new THREE.AnimationMixer(model);\n" +
            "\n" +
            "                let clips = fileAnimations.filter(val => val.name !== 'idle');\n" +
            "                possibleAnims = clips.map(val => {\n" +
            "                    let clip = THREE.AnimationClip.findByName(clips, val.name);\n" +
            "\n" +
            "                clip.tracks.splice(3, 3);\n" +
            "                clip.tracks.splice(9, 3);\n" +
            "\n" +
            "                clip = mixer.clipAction(clip);\n" +
            "                return clip;\n" +
            "            });\n" +
            "\n" +
            "\n" +
            "\n" +
            "            },\n" +
            "            undefined, // We don't need this function\n" +
            "            function (error) {\n" +
            "                console.error(error);\n" +
            "            });\n" +
            "\n" +
            "\n" +
            "            // Add lights\n" +
            "            let hemiLight = new THREE.HemisphereLight(0xffffff, 0xffffff, 0.61);\n" +
            "            hemiLight.position.set(0, 50, 0);\n" +
            "            // Add hemisphere light to scene\n" +
            "            scene.add(hemiLight);\n" +
            "\n" +
            "            let d = 8.25;\n" +
            "            let dirLight = new THREE.DirectionalLight(0xffffff, 0.54);\n" +
            "            dirLight.position.set(-8, 12, 8);\n" +
            "            dirLight.castShadow = true;\n" +
            "            dirLight.shadow.mapSize = new THREE.Vector2(1024, 1024);\n" +
            "            dirLight.shadow.camera.near = 0.1;\n" +
            "            dirLight.shadow.camera.far = 1500;\n" +
            "            dirLight.shadow.camera.left = d * -1;\n" +
            "            dirLight.shadow.camera.right = d;\n" +
            "            dirLight.shadow.camera.top = d;\n" +
            "            dirLight.shadow.camera.bottom = d * -1;\n" +
            "            // Add directional Light to scene\n" +
            "            scene.add(dirLight);\n" +
            "\n" +
            "\n" +
            "            // Floor\n" +
            "            let floorGeometry = new THREE.PlaneGeometry(5000, 5000, 1, 1);\n" +
            "            let floorMaterial = new THREE.MeshPhongMaterial({\n" +
            "                color: 0xeeeeee,\n" +
            "                shininess: 0 });\n" +
            "\n" +
            "\n" +
            "            let floor = new THREE.Mesh(floorGeometry, floorMaterial);\n" +
            "            floor.rotation.x = -0.5 * Math.PI;\n" +
            "            floor.receiveShadow = true;\n" +
            "            floor.position.y = -11;\n" +
            "            scene.add(floor);\n" +
            "\n" +
            "            let geometry = new THREE.SphereGeometry(8, 32, 32);\n" +
            "            let material = new THREE.MeshBasicMaterial({ color: 0x9bffaf }); // 0xf2ce2e \n" +
            "            let sphere = new THREE.Mesh(geometry, material);\n" +
            "\n" +
            "            sphere.position.z = -15;\n" +
            "            sphere.position.y = -2.5;\n" +
            "            sphere.position.x = -0.25;\n" +
            "            scene.add(sphere);\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "            function update() {\n" +
            "                if (mixer) {\n" +
            "                    mixer.update(clock.getDelta());\n" +
            "                }\n" +
            "\n" +
            "                if (resizeRendererToDisplaySize(renderer)) {\n" +
            "                    const canvas = renderer.domElement;\n" +
            "                    camera.aspect = canvas.clientWidth / canvas.clientHeight;\n" +
            "                    camera.updateProjectionMatrix();\n" +
            "                }\n" +
            "\n" +
            "                renderer.render(scene, camera);\n" +
            "                requestAnimationFrame(update);\n" +
            "            }\n" +
            "\n" +
            "            update();\n" +
            "\n" +
            "            function resizeRendererToDisplaySize(renderer) {\n" +
            "                const canvas = renderer.domElement;\n" +
            "                let width = window.innerWidth;\n" +
            "                let height = window.innerHeight;\n" +
            "                let canvasPixelWidth = canvas.width / window.devicePixelRatio;\n" +
            "                let canvasPixelHeight = canvas.height / window.devicePixelRatio;\n" +
            "\n" +
            "                const needResize =\n" +
            "                canvasPixelWidth !== width || canvasPixelHeight !== height;\n" +
            "                if (needResize) {\n" +
            "                    renderer.setSize(width, height, false);\n" +
            "                }\n" +
            "                return needResize;\n" +
            "            }\n" +
            "\n" +
            "\n" +
            "\n" +
            "                function moveJoint(mouse, joint, degreeLimit) {\n" +
            "                    let degrees = getMouseDegrees(mouse.x, mouse.y, degreeLimit);\n" +
            "                    joint.rotation.y = THREE.Math.degToRad(degrees.x);\n" +
            "                    joint.rotation.x = THREE.Math.degToRad(degrees.y);\n" +
            "                    console.log(joint.rotation.x);\n" +
            "                }\n" +
            "\n" +
            "            \n" +
            "                function start(){\n" +
            "                    setInterval(Engine , 200) ; \n" +
            "                }\n" +
            "\n" +
            "                function Engine(){\n" +
            "                    //neck.rotation.x = 1.1 ; \n" +
            "                    askForData();\n" +
            "                }\n" +
            "\n" +
            "            \n" +
            "                function askForData() {\n" +
            "                    $.get(\"http://localhost:1400/SinaRenderer\").done(actOnEvent);\n" +
            "                }\n" +
            "\n" +
            "                function actOnEvent(data) {\n" +
            "                    let info = data.split(\";\");\n" +
            "                    \n" +
            "\n" +
            "                    let vars = info[0].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setNeck(x , y , z );\n" +
            "\n" +
            "                    vars = info[1].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setWaist(x , y , z );\n" +
            "\n" +
            "                    vars = info[2].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setLeftShoulder(x , y , z );\n" +
            "\n" +
            "                    vars = info[3].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setRightShoulder(x , y , z ); \n" +
            "\n" +
            "                    vars = info[4].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setLeftElbow(x , y , z );\n" +
            "\n" +
            "                    vars = info[5].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setRightElbow(x , y , z ); \n" +
            "\n" +
            "                    vars = info[6].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setLeftWrist(x , y , z );\n" +
            "\n" +
            "                    vars = info[7].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setRightWrist(x , y , z );  \n" +
            "\n" +
            "                    vars = info[8].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setLeftThigh(x , y , z );\n" +
            "\n" +
            "                    vars = info[9].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setRightThigh(x , y , z );  \n" +
            "\n" +
            "                    vars = info[10].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setLeftKnee(x , y , z );\n" +
            "\n" +
            "                    vars = info[11].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setRightKnee(x , y , z );   \n" +
            "\n" +
            "                    vars = info[12].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setLeftAnkle(x , y , z );\n" +
            "\n" +
            "                    vars = info[13].split(\",\") ; \n" +
            "                    var x = (vars[0]) ;\n" +
            "                    var y = (vars[1]) ;\n" +
            "                    var z = (vars[2]) ; \n" +
            "                    setRightAnkle(x , y , z );  \n" +
            "\n" +
            "\n" +
            "                }\n" +
            "\n" +
            "                function setNeck(a,b,c){\n" +
            "                    neck.rotation.x = a ; \n" +
            "                    neck.rotation.y = b ; \n" +
            "                    neck.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setWaist(a,b,c){\n" +
            "                    waist.rotation.x = a ; \n" +
            "                    waist.rotation.y = b ; \n" +
            "                    waist.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setLeftShoulder(a,b,c){\n" +
            "                    leftShoulder.rotation.x = a ; \n" +
            "                    leftShoulder.rotation.y = b ; \n" +
            "                    leftShoulder.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setRightShoulder(a,b,c){\n" +
            "                    rightShoulder.rotation.x = a ; \n" +
            "                    rightShoulder.rotation.y = b ; \n" +
            "                    rightShoulder.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setLeftElbow(a,b,c){\n" +
            "                    leftElbow.rotation.x = a ; \n" +
            "                    leftElbow.rotation.y = b ; \n" +
            "                    leftElbow.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setRightElbow(a,b,c){\n" +
            "                    rightElbow.rotation.x = a ; \n" +
            "                    rightElbow.rotation.y = b ; \n" +
            "                    rightElbow.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setLeftWrist(a,b,c){\n" +
            "                    leftWrist.rotation.x = a ; \n" +
            "                    leftWrist.rotation.y = b ; \n" +
            "                    leftWrist.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setRightWrist(a,b,c){\n" +
            "                    rightWrist.rotation.x = a ; \n" +
            "                    rightWrist.rotation.y = b ; \n" +
            "                    rightWrist.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setLeftThigh(a,b,c){\n" +
            "                    leftThigh.rotation.x = a ; \n" +
            "                    leftThigh.rotation.y = b ; \n" +
            "                    leftThigh.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setRightThigh(a,b,c){\n" +
            "                    rightThigh.rotation.x = a ; \n" +
            "                    rightThigh.rotation.y = b ; \n" +
            "                    rightThigh.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setLeftKnee(a,b,c){\n" +
            "                    leftKnee.rotation.x = a ; \n" +
            "                    leftKnee.rotation.y = b ; \n" +
            "                    leftKnee.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setRightKnee(a,b,c){\n" +
            "                    rightKnee.rotation.x = a ; \n" +
            "                    rightKnee.rotation.y = b ; \n" +
            "                    rightKnee.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setLeftAnkle(a,b,c){\n" +
            "                    leftAnkle.rotation.x = a ; \n" +
            "                    leftAnkle.rotation.y = b ; \n" +
            "                    leftAnkle.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                function setRightAnkle(a,b,c){\n" +
            "                    rightAnkle.rotation.x = a ; \n" +
            "                    rightAnkle.rotation.y = b ; \n" +
            "                    rightAnkle.rotation.z = c ; \n" +
            "                }\n" +
            "\n" +
            "                window.addEventListener('keydown', e => keyH(e));\n" +
            "\n" +
            "                function keyH(event){\n" +
            "                    key = (event.keyCode) ; \n" +
            "                    if(key == 37){\n" +
            "                        model.rotation.y -= 0.1 ; \n" +
            "                    }else if(key == 39){\n" +
            "                        model.rotation.y += 0.1 ; \n" +
            "                    }\n" +
            "                }\n" +
            "\n" +
            "                })();\n" +
            "\n" +
            "\n" +
            "\n" +
            "\n" +
            "        </script>\n" +
            "\t</body>\n" +
            "</html>\n" ;

}
