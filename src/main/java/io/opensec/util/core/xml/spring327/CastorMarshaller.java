/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opensec.util.core.xml.spring327;
//package org.springframework.oxm.castor;

//import org.springframework.oxm.support.AbstractMarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.mapping.MappingException;
import org.exolab.castor.util.ObjectFactory;
import org.exolab.castor.xml.IDResolver;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.ResolverException;
import org.exolab.castor.xml.UnmarshalHandler;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.exolab.castor.xml.XMLClassDescriptorResolver;
import org.exolab.castor.xml.XMLContext;
import org.exolab.castor.xml.XMLException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.oxm.MarshallingFailureException;
import org.springframework.oxm.UncategorizedMappingException;
import org.springframework.oxm.UnmarshallingFailureException;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.castor.CastorMappingException;
import org.springframework.oxm.support.SaxResourceUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.xml.DomUtils;
import org.springframework.util.xml.StaxUtils;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;

/**
 * Implementation of the {@code Marshaller} interface for Castor. By default, Castor does
 * not require any further configuration, though setting target classes, target packages or
 * providing a mapping file can be used to have more control over the behavior of Castor.
 *
 * <p>If a target class is specified using {@code setTargetClass}, the {@code CastorMarshaller}
 * can only be used to unmarshal XML that represents that specific class. If you want to unmarshal
 * multiple classes, you have to provide a mapping file using {@code setMappingLocations}.
 *
 * <p>Due to limitations of Castor's API, it is required to set the encoding used for
 * writing to output streams. It defaults to {@code UTF-8}.
 *
 * @author Arjen Poutsma
 * @author Jakub Narloch
 * @author Juergen Hoeller
 * @since 3.0
 * @see #setEncoding(String)
 * @see #setTargetClass(Class)
 * @see #setTargetPackages(String[])
 * @see #setMappingLocation(Resource)
 * @see #setMappingLocations(Resource[])
 */
public class CastorMarshaller extends AbstractMarshaller implements InitializingBean, BeanClassLoaderAware {

	/**
	 * The default encoding used for stream access: UTF-8.
	 */
	public static final String DEFAULT_ENCODING = "UTF-8";


	private Resource[] mappingLocations;

	private String encoding = DEFAULT_ENCODING;

	private Class[] targetClasses;

	private String[] targetPackages;

	private boolean validating = false;

	private boolean suppressNamespaces = false;

	private boolean suppressXsiType = false;

	private boolean marshalAsDocument = true;

	private boolean marshalExtendedType = true;

	private String rootElement;

	private String noNamespaceSchemaLocation;

	private String schemaLocation;

	private boolean useXSITypeAtRoot = false;

	private boolean whitespacePreserve = false;

	private boolean ignoreExtraAttributes = true;

	private boolean ignoreExtraElements = false;

	private Object rootObject;

	private boolean reuseObjects = false;

	private boolean clearCollections = false;

	private Map<String, String> castorProperties;

	private Map<String, String> doctypes;

	private Map<String, String> processingInstructions;

	private Map<String, String> namespaceMappings;

	private Map<String, String> namespaceToPackageMapping;

	private EntityResolver entityResolver;

	private XMLClassDescriptorResolver classDescriptorResolver;

	private IDResolver idResolver;

	private ObjectFactory objectFactory;

	private ClassLoader beanClassLoader;

	private XMLContext xmlContext;


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

//    @Override
//    protected String getDefaultEncoding() {
//        return this.encoding;
//    }

	public void setMappingLocation(Resource mappingLocation) {
		this.mappingLocations = new Resource[]{mappingLocation};
	}

	public void setMappingLocations(Resource[] mappingLocations) {
		this.mappingLocations = mappingLocations;
	}

	public void setTargetClass(Class targetClass) {
		this.targetClasses = new Class[]{targetClass};
	}

	public void setTargetClasses(Class[] targetClasses) {
		this.targetClasses = targetClasses;
	}

	public void setTargetPackage(String targetPackage) {
		this.targetPackages = new String[] {targetPackage};
	}

	public void setTargetPackages(String[] targetPackages) {
		this.targetPackages = targetPackages;
	}

	public void setValidating(boolean validating) {
		this.validating = validating;
	}

	public void setSuppressNamespaces(boolean suppressNamespaces) {
		this.suppressNamespaces = suppressNamespaces;
	}

	public void setSuppressXsiType(boolean suppressXsiType) {
		this.suppressXsiType = suppressXsiType;
	}

	public void setMarshalAsDocument(boolean marshalAsDocument) {
		this.marshalAsDocument = marshalAsDocument;
	}

	public void setMarshalExtendedType(boolean marshalExtendedType) {
		this.marshalExtendedType = marshalExtendedType;
	}

	public void setRootElement(String rootElement) {
		this.rootElement = rootElement;
	}

	public void setNoNamespaceSchemaLocation(String noNamespaceSchemaLocation) {
		this.noNamespaceSchemaLocation = noNamespaceSchemaLocation;
	}

	public void setSchemaLocation(String schemaLocation) {
		this.schemaLocation = schemaLocation;
	}

	public void setUseXSITypeAtRoot(boolean useXSITypeAtRoot) {
		this.useXSITypeAtRoot = useXSITypeAtRoot;
	}

	public void setWhitespacePreserve(boolean whitespacePreserve) {
		this.whitespacePreserve = whitespacePreserve;
	}

	public void setIgnoreExtraAttributes(boolean ignoreExtraAttributes) {
		this.ignoreExtraAttributes = ignoreExtraAttributes;
	}

	public void setIgnoreExtraElements(boolean ignoreExtraElements) {
		this.ignoreExtraElements = ignoreExtraElements;
	}

	@Deprecated
	public void setObject(Object root) {
		this.rootObject = root;
	}

	public void setRootObject(Object root) {
		this.rootObject = root;
	}

	public void setReuseObjects(boolean reuseObjects) {
		this.reuseObjects = reuseObjects;
	}

	public void setClearCollections(boolean clearCollections) {
		this.clearCollections = clearCollections;
	}

	public void setCastorProperties(Map<String, String> castorProperties) {
		this.castorProperties = castorProperties;
	}

	public void setDoctypes(Map<String, String> doctypes) {
		this.doctypes = doctypes;
	}

	public void setProcessingInstructions(Map<String, String> processingInstructions) {
		this.processingInstructions = processingInstructions;
	}

	public void setNamespaceMappings(Map<String, String> namespaceMappings) {
		this.namespaceMappings = namespaceMappings;
	}

	public void setNamespaceToPackageMapping(Map<String, String> namespaceToPackageMapping) {
		this.namespaceToPackageMapping = namespaceToPackageMapping;
	}

	public void setEntityResolver(EntityResolver entityResolver) {
		this.entityResolver = entityResolver;
	}

	public void setClassDescriptorResolver(XMLClassDescriptorResolver classDescriptorResolver) {
		this.classDescriptorResolver = classDescriptorResolver;
	}

	public void setIdResolver(IDResolver idResolver) {
		this.idResolver = idResolver;
	}

	public void setObjectFactory(ObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	@Override
    public void setBeanClassLoader(ClassLoader classLoader) {
		this.beanClassLoader = classLoader;
	}


	@Override
    public void afterPropertiesSet() throws CastorMappingException, IOException {
		try {
			this.xmlContext = createXMLContext(this.mappingLocations, this.targetClasses, this.targetPackages);
		}
		catch (MappingException ex) {
			throw new CastorMappingException("Could not load Castor mapping", ex);
		}
		catch (ResolverException ex) {
			throw new CastorMappingException("Could not resolve Castor mapping", ex);
		}
	}

	protected XMLContext createXMLContext(Resource[] mappingLocations, Class[] targetClasses, String[] targetPackages)
			throws MappingException, ResolverException, IOException {

		XMLContext context = new XMLContext();
		if (!ObjectUtils.isEmpty(mappingLocations)) {
			Mapping mapping = new Mapping();
			for (Resource mappingLocation : mappingLocations) {
				mapping.loadMapping(SaxResourceUtils.createInputSource(mappingLocation));
			}
			context.addMapping(mapping);
		}
		if (!ObjectUtils.isEmpty(targetClasses)) {
			context.addClasses(targetClasses);
		}
		if (!ObjectUtils.isEmpty(targetPackages)) {
			context.addPackages(targetPackages);
		}
		if (this.castorProperties != null) {
			for (Map.Entry<String, String> property : this.castorProperties.entrySet()) {
				context.setProperty(property.getKey(), property.getValue());
			}
		}
		return context;
	}


	/**
	 * Returns {@code true} for all classes, i.e. Castor supports arbitrary classes.
	 */
	@Override
    public boolean supports(Class<?> clazz) {
		return true;
	}

	// Marshalling

	@Override
	protected final void marshalDomNode(Object graph, Node node) throws XmlMappingException {
		marshalSaxHandlers(graph, DomUtils.createContentHandler(node), null);
	}

	@Override
	protected final void marshalSaxHandlers(Object graph, ContentHandler contentHandler, LexicalHandler lexicalHandler)
			throws XmlMappingException {

		Marshaller marshaller = xmlContext.createMarshaller();
		marshaller.setContentHandler(contentHandler);
		marshal(graph, marshaller);
	}

	@Override
	protected final void marshalOutputStream(Object graph, OutputStream outputStream)
			throws XmlMappingException, IOException {

		marshalWriter(graph, new OutputStreamWriter(outputStream, encoding));
	}

	@Override
	protected final void marshalWriter(Object graph, Writer writer) throws XmlMappingException, IOException {
		Marshaller marshaller = xmlContext.createMarshaller();
		marshaller.setWriter(writer);
		marshal(graph, marshaller);
	}

	@Override
	protected final void marshalXmlEventWriter(Object graph, XMLEventWriter eventWriter) throws XmlMappingException {
		marshalSaxHandlers(graph, StaxUtils.createContentHandler(eventWriter), null);
	}

	@Override
	protected final void marshalXmlStreamWriter(Object graph, XMLStreamWriter streamWriter) throws XmlMappingException {
		marshalSaxHandlers(graph, StaxUtils.createContentHandler(streamWriter), null);
	}

	private void marshal(Object graph, Marshaller marshaller) {
		try {
			customizeMarshaller(marshaller);
			marshaller.marshal(graph);
		}
		catch (XMLException ex) {
			throw convertCastorException(ex, true);
		}
	}

	protected void customizeMarshaller(Marshaller marshaller) {
		marshaller.setValidation(this.validating);
		marshaller.setSuppressNamespaces(this.suppressNamespaces);
		marshaller.setSuppressXSIType(this.suppressXsiType);
		marshaller.setMarshalAsDocument(this.marshalAsDocument);
		marshaller.setMarshalExtendedType(this.marshalExtendedType);
		marshaller.setRootElement(this.rootElement);
		marshaller.setNoNamespaceSchemaLocation(this.noNamespaceSchemaLocation);
		marshaller.setSchemaLocation(this.schemaLocation);
		marshaller.setUseXSITypeAtRoot(this.useXSITypeAtRoot);
		if (this.doctypes != null) {
			for (Map.Entry<String, String> doctype : this.doctypes.entrySet()) {
				marshaller.setDoctype(doctype.getKey(), doctype.getValue());
			}
		}
		if (this.processingInstructions != null) {
			for (Map.Entry<String, String> processingInstruction : this.processingInstructions.entrySet()) {
				marshaller.addProcessingInstruction(processingInstruction.getKey(), processingInstruction.getValue());
			}
		}
		if (this.namespaceMappings != null) {
			for (Map.Entry<String, String> entry : this.namespaceMappings.entrySet()) {
				marshaller.setNamespaceMapping(entry.getKey(), entry.getValue());
			}
		}
	}

	// Unmarshalling

	@Override
	protected final Object unmarshalDomNode(Node node) throws XmlMappingException {
		try {
			return createUnmarshaller().unmarshal(node);
		}
		catch (XMLException ex) {
			throw convertCastorException(ex, false);
		}
	}

	@Override
	protected final Object unmarshalInputStream(InputStream inputStream) throws XmlMappingException, IOException {
		try {
			return createUnmarshaller().unmarshal(new InputSource(inputStream));
		}
		catch (XMLException ex) {
			throw convertCastorException(ex, false);
		}
	}

	@Override
	protected final Object unmarshalReader(Reader reader) throws XmlMappingException, IOException {
		try {
			return createUnmarshaller().unmarshal(new InputSource(reader));
		}
		catch (XMLException ex) {
			throw convertCastorException(ex, false);
		}
	}

	@Override
	protected final Object unmarshalSaxReader(XMLReader xmlReader, InputSource inputSource)
			throws XmlMappingException, IOException {

		UnmarshalHandler unmarshalHandler = createUnmarshaller().createHandler();
		try {
			ContentHandler contentHandler = Unmarshaller.getContentHandler(unmarshalHandler);
			xmlReader.setContentHandler(contentHandler);
			xmlReader.parse(inputSource);
			return unmarshalHandler.getObject();
		}
		catch (SAXException ex) {
			throw new UnmarshallingFailureException("SAX reader exception", ex);
		}
	}

	@Override
	protected final Object unmarshalXmlEventReader(XMLEventReader eventReader) {
		try {
			return createUnmarshaller().unmarshal(eventReader);
		}
		catch (XMLException ex) {
			throw convertCastorException(ex, false);
		}
	}

	@Override
	protected final Object unmarshalXmlStreamReader(XMLStreamReader streamReader) {
		try {
			return createUnmarshaller().unmarshal(streamReader);
		}
		catch (XMLException ex) {
			throw convertCastorException(ex, false);
		}
	}

	private Unmarshaller createUnmarshaller() {
		Unmarshaller unmarshaller = this.xmlContext.createUnmarshaller();
		customizeUnmarshaller(unmarshaller);
		return unmarshaller;
	}

	protected void customizeUnmarshaller(Unmarshaller unmarshaller) {
		unmarshaller.setValidation(this.validating);
		unmarshaller.setWhitespacePreserve(this.whitespacePreserve);
		unmarshaller.setIgnoreExtraAttributes(this.ignoreExtraAttributes);
		unmarshaller.setIgnoreExtraElements(this.ignoreExtraElements);
		unmarshaller.setObject(this.rootObject);
		unmarshaller.setReuseObjects(this.reuseObjects);
		unmarshaller.setClearCollections(this.clearCollections);
		if (this.namespaceToPackageMapping != null) {
			for (Map.Entry<String, String> mapping : this.namespaceToPackageMapping.entrySet()) {
				unmarshaller.addNamespaceToPackageMapping(mapping.getKey(), mapping.getValue());
			}
		}
		if (this.entityResolver != null) {
			unmarshaller.setEntityResolver(this.entityResolver);
		}
		if (this.classDescriptorResolver != null) {
			unmarshaller.setResolver(this.classDescriptorResolver);
		}
		if (this.idResolver != null) {
			unmarshaller.setIDResolver(this.idResolver);
		}
		if (this.objectFactory != null) {
			unmarshaller.setObjectFactory(this.objectFactory);
		}
		if (this.beanClassLoader != null) {
			unmarshaller.setClassLoader(this.beanClassLoader);
		}
	}

	/**
	 * Convert the given {@code XMLException} to an appropriate exception from the
	 * {@code org.springframework.oxm} hierarchy.
	 * <p>A boolean flag is used to indicate whether this exception occurs during marshalling or
	 * unmarshalling, since Castor itself does not make this distinction in its exception hierarchy.
	 * @param ex Castor {@code XMLException} that occurred
	 * @param marshalling indicates whether the exception occurs during marshalling ({@code true}),
	 * or unmarshalling ({@code false})
	 * @return the corresponding {@code XmlMappingException}
	 */
	protected XmlMappingException convertCastorException(XMLException ex, boolean marshalling) {
		if (ex instanceof ValidationException) {
			return new ValidationFailureException("Castor validation exception", ex);
		}
		else if (ex instanceof MarshalException) {
			if (marshalling) {
				return new MarshallingFailureException("Castor marshalling exception", ex);
			}
			else {
				return new UnmarshallingFailureException("Castor unmarshalling exception", ex);
			}
		}
		else {
			// fallback
			return new UncategorizedMappingException("Unknown Castor exception", ex);
		}
	}

}
